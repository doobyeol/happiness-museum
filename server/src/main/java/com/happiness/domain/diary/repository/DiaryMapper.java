package com.happiness.domain.diary.repository;

import com.happiness.domain.diary.dto.DiaryDto;
import com.happiness.domain.user.dto.HappinessDto;
import com.happiness.domain.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper {
    List<DiaryDto> findDiaryList();
}
