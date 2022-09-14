package com.happiness.domain.diary.service;

import com.happiness.domain.diary.dto.DiaryDto;
import com.happiness.domain.diary.repository.DiaryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryMapper diaryMapper;

    public Page<DiaryDto> findDiaryList(Pageable pageable) {
        List<DiaryDto> list = diaryMapper.findDiaryList(pageable);
        Integer totalCount = diaryMapper.findDiaryTotalCount();
        return new PageImpl(list, pageable, totalCount);
    }

    public DiaryDto saveDiary(DiaryDto diaryDto) {
        Integer row = diaryMapper.insertDiary(diaryDto);
        return null;
    }
 }
