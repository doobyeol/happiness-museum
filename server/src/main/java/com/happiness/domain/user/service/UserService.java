package com.happiness.domain.user.service;

import com.happiness.domain.user.dto.HappinessDto;
import com.happiness.domain.user.dto.UserDto;
import com.happiness.domain.user.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public UserDto findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

    // 서비스 CRUD 명명규칙 : 조회는 get, 저장은 save, 수정은 modify, 삭제는 remove
    // 쿼리 : find, insert, update, delete
    public List<HappinessDto> getHappinessList() {
        return userMapper.findHappinessList();
    }
 }
