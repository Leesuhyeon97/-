package com.triple.point.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper

public interface ReviewDAO {
    public String getReviewPoint(int no) throws Exception;
}
