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

        // 사용자의 ID, PW 룰 조합한 UsernamePasswordAuthenticationToken 생성
        // 검증을 위해 AuthenticationManager의 인스턴스로 전달 -> 이때 Password 체크가 내부적으로 처리됨
        // ID, PW 틀리면 AuthEntryPointJwt 호출하여 에러 메세지가 나온다.
        // 인증 성공시 AuthenticationManager는 Authentication 인스턴스를 리턴
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserId(), loginRequest.getUserPw()));

        // Authentication 객체를 SecurityContextHolder의 Contetx에 저장
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // JwtUtils 토큰 생성
        String token = jwtUtils.generateJwtToken(authentication);
        String refreshToken = jwtUtils.generateRefreshJwtToken(token);

        // Authentication 객체의 getPrincipal() 메서드를 실행하게 되면, UserDetails를 구현한 사용자 객체를 Return
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // 토큰을 생성한 후 userId, userNm, userMail, token, refreshToken을 반환한다.
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
