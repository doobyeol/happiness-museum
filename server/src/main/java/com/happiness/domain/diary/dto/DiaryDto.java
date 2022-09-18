package com.happiness.domain.diary.dto;

import com.happiness.domain.common.dto.CommonDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DiaryDto extends CommonDto {
    private long diaryNo;
    private String userId;
    private String userNm;
    private String title;
    private String content;
    private String fileUrl;
    private int view;
    private String emotion;
    private String weather;
    private String today;
    private String tomorrow;
    private boolean isPublic;
    private String targetDt;
}
