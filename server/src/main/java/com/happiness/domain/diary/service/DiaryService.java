package com.happiness.domain.diary.service;

import com.happiness.domain.common.constants.ResultCode;
import com.happiness.domain.common.exceptions.BizException;
import com.happiness.domain.diary.dto.DiaryDto;
import com.happiness.domain.diary.repository.DiaryMapper;
import com.happiness.domain.user.dto.UserDto;
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

    public DiaryDto saveDiary(UserDto userDto, DiaryDto diaryDto) {
        diaryDto.setUserId(userDto.getUserId());
        diaryDto.setUserNm(userDto.getUserNm());
        diaryDto.setCreateId(userDto.getUserId());
        diaryDto.setUpdateId(userDto.getUserId());

        Integer row = diaryMapper.insertDiary(diaryDto);
        if (row < 1) {
            throw new BizException(ResultCode.FAILED_SAVE);
        }
        return diaryMapper.findDiaryByDiaryNo(diaryDto.getDiaryNo());
    }
 }
