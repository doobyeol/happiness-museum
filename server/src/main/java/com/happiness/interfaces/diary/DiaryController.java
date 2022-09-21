package com.happiness.interfaces.diary;

import com.happiness.domain.diary.dto.DiaryDto;
import com.happiness.domain.diary.service.DiaryService;
import com.happiness.domain.security.helper.RequestContextHelper;
import com.happiness.domain.user.dto.UserDto;
import com.happiness.interfaces.common.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/diary")
@Slf4j
public class DiaryController {
    private final DiaryService diaryService;

    @GetMapping("/list")
    public ResponseDto<Page<DiaryDto>> getDiaryList(Pageable pageable) {
        return ResponseDto.ok(diaryService.findDiaryList(pageable));
    }

    @PostMapping("")
    public ResponseDto<DiaryDto> saveDiary(DiaryDto diaryDto) {
        UserDto userDto = RequestContextHelper.getLoginUserInfo();
        return  ResponseDto.ok(diaryService.saveDiary(userDto, diaryDto));
    }

    @PutMapping("")
    public ResponseDto<DiaryDto> modifyDiary(DiaryDto diaryDto) {
        UserDto userDto = RequestContextHelper.getLoginUserInfo();
        return  ResponseDto.ok(diaryService.modifyDiary(userDto, diaryDto));
    }

    @DeleteMapping("")
    public ResponseDto removeDiary(DiaryDto diaryDto) {
        UserDto userDto = RequestContextHelper.getLoginUserInfo();
        diaryService.removeDiary(userDto, diaryDto);
        return  ResponseDto.ok();
    }

}
