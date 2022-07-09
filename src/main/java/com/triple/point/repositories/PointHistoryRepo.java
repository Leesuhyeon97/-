package com.triple.point.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triple.point.entities.PointHistoryEntity;

@Repository
public interface PointHistoryRepo extends JpaRepository<PointHistoryEntity, Long> {
    Optional<PointHistoryEntity> findByreviewId(String reviewId);
    List<PointHistoryEntity> findByPlaceId(String placeId);
    Optional<PointHistoryEntity> findByuserIdAndplaceId(String userId, String placeId);
}
