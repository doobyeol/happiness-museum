package com.happiness.domain.diary.service;

import com.happiness.domain.common.constants.ResultCode;
import com.happiness.domain.common.exceptions.BizException;
import com.happiness.domain.diary.dto.DiaryDto;
import com.happiness.domain.diary.repository.DiaryMapper;
import com.happiness.domain.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
public class DiaryServiceTest {

    private DiaryMapper diaryMapper = mock(DiaryMapper.class);
    private DiaryService stub = new DiaryService(diaryMapper);


    @Test
    @DisplayName("diary 저장 성공")
    public void test_happy_case() {
        UserDto userDto = new UserDto();
        DiaryDto diaryDto = new DiaryDto();
        DiaryDto expectedDiaryDto = new DiaryDto();
        expectedDiaryDto.setDiaryNo(1);

        when(diaryMapper.insertDiary(any())).thenReturn(1);
        when(diaryMapper.findDiaryByDiaryNo(any())).thenReturn(expectedDiaryDto);

        DiaryDto resultDto = stub.saveDiary(userDto, diaryDto);

        assertEquals(1, resultDto.getDiaryNo());
    }

    @Test
    @DisplayName("diary 저장 실패")
    public void test_bad_case() {
        UserDto userDto = new UserDto();
        DiaryDto diaryDto = new DiaryDto();
        DiaryDto expectedDiaryDto = new DiaryDto();
        expectedDiaryDto.setDiaryNo(1);

        when(diaryMapper.insertDiary(any())).thenReturn(0);
        when(diaryMapper.findDiaryByDiaryNo(any())).thenReturn(expectedDiaryDto);

        BizException exception = assertThrows(BizException.class, () -> {
            stub.saveDiary(userDto, diaryDto);
        });
        assertEquals(ResultCode.FAILED_SAVE, exception.getResultCode());
    }

}
