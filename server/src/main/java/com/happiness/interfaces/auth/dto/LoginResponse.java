package com.happiness.interfaces.auth.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class LoginResponse {
    private String type = "Bearer";
    private String userId;
    private String userNm;
    private String userMail;
    private List<String> roles;
    private String token;
    private String refreshToken;
}
