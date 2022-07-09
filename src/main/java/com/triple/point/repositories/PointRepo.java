package com.triple.point.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triple.point.entities.PointEntity;

@Repository
public interface PointRepo extends JpaRepository<PointEntity, Long>{
    Optional<PointEntity> findByUserId(String userId);
}
