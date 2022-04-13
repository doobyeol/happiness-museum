package com.happiness.interfaces.user;

import com.happiness.domain.user.dto.UserDto;
import com.happiness.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{userId}")
    public UserDto getUser(@PathVariable String userId) {
        return userService.findUserById(userId);
    }
}
