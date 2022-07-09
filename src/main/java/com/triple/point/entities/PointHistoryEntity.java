package com.triple.point.entities;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class PointHistoryEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num;
    @Column(name = "review_id")
    private String reviewId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "place_Id")
    private String placeId;
    @Column(name = "review_point")
    private int point;
    @Column(name = "create_timeStamp")
    private LocalDateTime createTimeStamp = LocalDateTime.now();

    PointHistoryEntity (String userId, String placeId, int point) {
        this.userId = userId;
        this.placeId = placeId;
        this.point = point;
    }

    public static PointHistoryEntity of(String userId, String placeId, int point) {
        return new PointHistoryEntity(userId, placeId, point);
    }
}
