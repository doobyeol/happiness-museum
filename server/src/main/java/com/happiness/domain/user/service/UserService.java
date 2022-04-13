package com.happiness.domain.user.service;

import com.happiness.domain.user.dto.UserDto;
import com.happiness.domain.user.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    public UserDto findUserById(String userId) {
        return userMapper.findUserById(userId);
    }
}
