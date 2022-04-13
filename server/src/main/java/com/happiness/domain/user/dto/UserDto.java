package com.happiness.domain.user.dto;


import com.happiness.domain.common.dto.CommonDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto extends CommonDto {
    private String userId;
    private String userPw;
    private String userNm;
    private String userTel;
    private String isBlock;
    private String gender;
    private String userMail;
    private String address;
    private String mbti;
    private String birthDate;
    private String birthGift;
    private String happiness;
    private String isPostit;
}
