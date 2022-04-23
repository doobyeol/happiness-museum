package com.happiness.interfaces.user;

import com.happiness.domain.security.auth.UserDetailsImpl;
import com.happiness.domain.security.jwt.JwtUtils;
import com.happiness.domain.user.dto.UserDto;
import com.happiness.domain.user.service.UserService;
import com.happiness.interfaces.user.dto.LoginRequest;
import com.happiness.interfaces.user.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/{userId}")
//    @Secured("ROLE_USER")
    public UserDto getUser(@PathVariable String userId) {
        return userService.findUserById(userId);
    }


    @PostMapping(value = "/auth/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        log.info("loginRequest : ", loginRequest);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserId(), loginRequest.getUserPw()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtUtils.generateJwtToken(authentication);
        String refreshToken = jwtUtils.generateRefreshJwtToken(token);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        LoginResponse loginResponse = LoginResponse.builder()
                .userId(userDetails.getUsername())
                .userNm(userDetails.getUserNm())
                .userMail(userDetails.getUserMail())
                .token(token)
                .refreshToken(refreshToken)
                .build();

        return loginResponse;
    }

}
