package com.happiness.domain.user.repository;

import com.happiness.domain.user.dto.HappinessDto;
import com.happiness.domain.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserDto findUserById(String userId);
    List<HappinessDto> findHappinessList();
}
