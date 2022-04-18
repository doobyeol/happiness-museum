package com.happiness.domain.user.repository;

import com.happiness.domain.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserDto findUserById(String userId);
}
