package com.happiness.domain.user.dto;

import com.happiness.domain.common.dto.CommonDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HappinessDto extends CommonDto {
    private String userNm;
    private String happiness;
}