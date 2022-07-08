package com.triple.point.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.triple.point.service.ReviewService;
import com.triple.point.vo.ReviewVO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    // 클럽 마일리지 적립
    @PostMapping("/point")
    public ResponseEntity getPoint(@RequestBody ReviewVO reviewVO) {
        boolean result = reviewService.getReviewPoint(reviewVO);

        return new ResponseEntity(HttpStatus.OK);
    }

    // 클럽 마일리지 조회
    @GetMapping(value = "point")
    public ResponseEntity findPoint() {
        return new ResponseEntity(HttpStatus.OK);
    }

}
