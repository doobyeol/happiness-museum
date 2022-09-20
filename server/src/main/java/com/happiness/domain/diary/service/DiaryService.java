package com.happiness.domain.diary.service;

import com.happiness.domain.common.constants.ResultCode;
import com.happiness.domain.common.exceptions.BizException;
import com.happiness.domain.diary.dto.DiaryDto;
import com.happiness.domain.diary.repository.DiaryMapper;
import com.happiness.domain.user.dto.UserDto;
import com.happiness.interfaces.common.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
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

    public DiaryDto modifyDiary(UserDto userDto, DiaryDto diaryDto) {
        DiaryDto oldDairyDto = diaryMapper.findDiaryByDiaryNo(diaryDto.getDiaryNo());
        if (oldDairyDto == null) {
            throw new BizException(ResultCode.INVALID_REQUEST);
        }
        if (!StringUtils.equals(oldDairyDto.getCreateId(), userDto.getUserId())) {
            throw new BizException(ResultCode.INVALID_REQUESTER);
        }
        diaryDto.setUpdateId(userDto.getUserId());
        Integer row = diaryMapper.updateDiary(diaryDto);
        if (row < 1) {
            throw new BizException(ResultCode.FAILED_SAVE);
        }
        return diaryMapper.findDiaryByDiaryNo(diaryDto.getDiaryNo());
    }


    public void removeDiary(UserDto userDto, DiaryDto diaryDto) {
        DiaryDto oldDairyDto = diaryMapper.findDiaryByDiaryNo(diaryDto.getDiaryNo());
        if (oldDairyDto == null) {
            throw new BizException(ResultCode.INVALID_REQUEST);
        }
        if (!StringUtils.equals(oldDairyDto.getCreateId(), userDto.getUserId())) {
            throw new BizException(ResultCode.INVALID_REQUESTER);
        }
        Integer row = diaryMapper.deleteDiary(diaryDto);
        if (row < 1) {
            throw new BizException(ResultCode.FAILED_DELETE);
        }
    }
 }
