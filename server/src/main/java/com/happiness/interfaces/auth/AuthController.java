package com.happiness.interfaces.auth;

import com.happiness.domain.security.auth.UserDetailsImpl;
import com.happiness.domain.security.auth.dto.JwtResponse;
import com.happiness.interfaces.auth.dto.TokenResponse;
import com.happiness.interfaces.user.dto.LoginRequest;
import com.happiness.interfaces.user.dto.LoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.happiness.domain.security.jwt.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {
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
        return loginResponse;
    }

    /**
     * refresh token 재발급
     */
    @GetMapping("/getRefreshToken")
    public TokenResponse getRefreshToken(HttpServletRequest request) {
        String token = "";
        String refreshToken = "";

        // Token 유효성 확인
        if (jwtUtils.validateJwtToken(parseJwt(request))) {
            // Token 생성
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            token = jwtUtils.generateJwtToken(authentication);
            refreshToken = jwtUtils.generateRefreshJwtToken(token);
        }

        TokenResponse tokenResponse = TokenResponse.builder()
                .token(token)
                .refreshToken(refreshToken)
                .build();

        return tokenResponse;
    }

    private String parseJwt(HttpServletRequest request) {
        // header에서 Authorization 값을 가져오고 그 값이 있거나
        // startWith 시작하는 부분이 Bearer로 시작한다면 headerAuth.substring 리턴한다.
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }

}