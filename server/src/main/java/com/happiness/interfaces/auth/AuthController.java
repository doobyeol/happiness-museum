package com.happiness.interfaces.auth;

import com.happiness.domain.common.constants.ResultCode;
import com.happiness.domain.security.auth.UserDetailsImpl;
import com.happiness.interfaces.auth.dto.RefreshTokenRequest;
import com.happiness.interfaces.auth.dto.TokenResponse;
import com.happiness.interfaces.common.dto.ResponseDto;
import com.happiness.interfaces.auth.dto.LoginRequest;
import com.happiness.interfaces.auth.dto.LoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.happiness.domain.security.jwt.JwtUtils;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseDto<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {

        // username, password 틀리면 AuthEntryPointJwt 호출하여 에러 메세지가 나온다.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken
                        (loginRequest.getUserId(), loginRequest.getUserPw()));

        // Authentication 객체를 SecurityContextHolder의 Contetx에 저장하고
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // username, password 맞으면 토큰을 생성하고
        String token = jwtUtils.generateJwtToken(authentication);
        String refreshToken = jwtUtils.generateRefreshJwtToken(token);

        // Authentication 객체의 getPrincipal() 메서드를 실행하게 되면,
        // UserDetails를 구현한 사용자 객체를 Return
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        // 토큰을 생성한 후 userId, userNm, userMail, token, refreshToken을 반환한다.
        LoginResponse loginResponse = LoginResponse.builder()
                .userId(userDetails.getUsername())
                .userNm(userDetails.getUserNm())
                .userMail(userDetails.getUserMail())
                .token(token)
                .refreshToken(refreshToken)
                .build();

        // 반환 값으로 loginResponse를 반환한다.
        return ResponseDto.ok(loginResponse);
    }

    /**
     * refresh token 재발급
     */
    @PostMapping("/token/refresh")
    public ResponseDto<TokenResponse> refreshToken(
        @RequestBody RefreshTokenRequest refreshTokenRequest,
        HttpServletResponse response) {
        String token = "";
        String refreshToken = "";

        String legacyRefreshToken = refreshTokenRequest.getRefreshToken();

        // Token 유효성 확인
        if (jwtUtils.validateJwtToken(legacyRefreshToken)) {
            // Token 생성
            token = jwtUtils.generateJwtToken(legacyRefreshToken);
            refreshToken = jwtUtils.generateRefreshJwtToken(token);
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return ResponseDto.fail(ResultCode.INVALID_REFRESH_TOKEN);
        }

        TokenResponse tokenResponse = TokenResponse.builder()
                .token(token)
                .refreshToken(refreshToken)
                .build();

        return ResponseDto.ok(tokenResponse);
    }

}