package com.happiness.interfaces.user;

import com.happiness.domain.user.dto.UserDto;
import com.happiness.domain.user.service.UserService;
import com.happiness.interfaces.common.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
//    @Secured("ROLE_USER")
    public ResponseDto<UserDto> getUser(@PathVariable String userId) {
        return ResponseDto.ok(userService.findUserById(userId));
    }

}
