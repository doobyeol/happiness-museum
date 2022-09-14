package com.happiness.domain.diary.repository;

import com.happiness.domain.diary.dto.DiaryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface DiaryMapper {
    List<DiaryDto> findDiaryList(@Param("pageable") Pageable pageable);
    Integer findDiaryTotalCount();
    Integer insertDiary(DiaryDto diaryDto);
}
