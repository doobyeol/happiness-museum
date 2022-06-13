package com.happiness.domain.security.auth.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
@Builder
public class JwtResponse {
    private String type = "Bearer";
    private String userId;
    private String userNm;
    private String userMail;
    private List<String> roles;
    private String token;
    private String refreshToken;

    public JwtResponse(String userId, String userNm, String userMail, List<String> roles, String token, String refreshToken) {
        super();
        this.userId = userId;
        this.userNm = userNm;
        this.userMail = userMail;
        this.roles = roles;
        this.token = token;
        this.refreshToken = refreshToken;
    }

    public JwtResponse() {
        super();
    }

    public JwtResponse(String jwt, String userId, String userNm, String userMail, List<String> roles) {
    }
}