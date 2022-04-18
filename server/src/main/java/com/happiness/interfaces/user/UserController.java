package com.happiness.interfaces.user;

import com.happiness.domain.user.dto.UserDto;
import com.happiness.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
//    @Secured("ROLE_USER")
    public UserDto getUser(@PathVariable String userId) {
        return userService.findUserById(userId);
    }


    @PostMapping(value = "/login")
    public UserDto login(@RequestBody UserDto userDto) {
        log.info("userDto : ", userDto);
        return userService.findUserById("");
    }

}
