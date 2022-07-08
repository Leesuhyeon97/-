package com.triple.point.vo;

import com.triple.point.enums.*;

public class ReviewVO {
    private String type;
    private String action;
    private String reviewId;
    private String content;
    private String[] attachedPhotoIds;
    private String userId;
    private String placeId;

    public String getType() {
        return this.type;
    }

    public String getAction() {
        return this.action;
    }

    public String getReviewId() {
        return this.reviewId;
    }

    public String getContent() {
        return this.content;
    }

    public String[] getAttachedPhotoIds() {
        return this.attachedPhotoIds;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getPlaceId() {
        return this.placeId;
    }

}
