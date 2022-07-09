package com.triple.point.entities;

import java.time.LocalDateTime;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PointEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "cal_point")
    private int point;
    @Column(name = "total_point")
    private long totalPoint;
    @Column(name = "create_timeStamp")
    private LocalDateTime createTimeStamp = LocalDateTime.now();
    @Column(name = "update_timeStamp")
    private LocalDateTime updateTimeStamp = LocalDateTime.now();

    PointEntity(String userId) {
        this.userId = userId;
    }

    public static PointEntity of(String userId) {
        return new PointEntity(userId);
    }

    public void updateUserReviewPoint(int reviewPoint) {
        this.totalPoint += point;
    }

}
