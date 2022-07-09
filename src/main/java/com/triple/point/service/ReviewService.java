package com.triple.point.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triple.point.vo.ReviewVO;

import lombok.RequiredArgsConstructor;

import com.triple.point.entities.PointEntity;
import com.triple.point.entities.PointHistoryEntity;
import com.triple.point.enums.*;
import com.triple.point.repositories.PointHistoryRepo;
import com.triple.point.repositories.PointRepo;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final PointRepo pointRepo;
    private final PointHistoryRepo pointHistoryRepo;

    @Transactional
    public boolean getReviewPoint(ReviewVO reviewVO) {
        int reviewPoint = 0;

        //사용자의 포인트내역을 확인
        Optional<PointEntity> userReviewPoint = pointRepo.findByUserId(reviewVO.getUserId());

        switch (reviewVO.getAction()) {
            case ADD:
                // 리뷰를 작성했을 때 포인트 계산으로 넘김
                reviewPoint = addReviewPoint(reviewVO.getContent(), reviewVO.getAttachedPhotoIds(), reviewVO.getPlaceId());

                break;

            case MOD:
                // 리뷰를 수정했을 때 포인트 계산으로 넘김
                reviewPoint = modReviewPoint(reviewVO.getContent(), reviewVO.getAttachedPhotoIds(), reviewVO.getPlaceId());
                
                break;

            case DELETE:
                // 리뷰를 삭제했을 때 포인트를 계산을 바로 함
                Optional<PointHistoryEntity> pointHistoryEntity = pointHistoryRepo.findByreviewId(reviewVO.getReviewId());
                reviewPoint = pointHistoryEntity.get().getPoint() * (0);
                userReviewPoint.get().updateUserReviewPoint(reviewPoint);
                break;

        }

        //포인트 전체 증감내역을 기록 
        PointHistoryEntity pointHistoryEntity = PointHistoryEntity.of(reviewVO.getUserId(), reviewVO.getPlaceId(), reviewPoint);
        pointHistoryRepo.save(pointHistoryEntity);


        return true;
    }

    // 리뷰 ADD 포인트 계산 부분
    private int addReviewPoint(String content, String[] attachedPhotoIds, String placeId) {
        int reviewPoint = 0;
        List<PointHistoryEntity> presentPointHistory = pointHistoryRepo.findByPlaceId(placeId);

        // 해당 장소의 첫번째 리뷰 작성 시
        if(presentPointHistory.size() == 0) {
            reviewPoint += 1;
        }
        // 1글자 이상 리뷰 작성시
        if (content.length() > 0) {
            reviewPoint += 1;
        }
        // 1장 이상 사진 첨부 시
        if (attachedPhotoIds.length > 0) {
            reviewPoint += 1;
        }

        return reviewPoint;
    }

    // 리뷰 MOD 포인트 계산 부분
    private int modReviewPoint(String content, String[] attachedPhotoIds, String placeId) {
        int reviewPoint = 0; // 이거 포인트 내역조회로 해서 포인트 받아와야함
        
        // 글을 없애고 수정할 시
        if (content.length() < 0 || content.length() == 0) {
            reviewPoint -= 1;
        }
        // 사진을 없애고 수정할 시
        if (attachedPhotoIds.length < 0 || attachedPhotoIds.length == 0) {
            reviewPoint -= 1;
        }
        // 1글자 이상 글 작성시
        if (content.length() > 0) {
            reviewPoint += 1;
        }
        // 1장 이상 사진 첨부 시
        if (attachedPhotoIds.length > 0) {
            reviewPoint += 1;
        }

        return reviewPoint;
    }

}
