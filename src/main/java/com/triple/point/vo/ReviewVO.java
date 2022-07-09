package com.triple.point.vo;

import com.triple.point.enums.*;
import lombok.Getter;

@Getter
public class ReviewVO {
    private String type;
    private ActionEnums action;
    private String reviewId;
    private String content;
    private String[] attachedPhotoIds;
    private String userId;
    private String placeId;

}
