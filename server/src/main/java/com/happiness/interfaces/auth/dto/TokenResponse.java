package com.happiness.interfaces.auth.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class TokenResponse {
    private String token;
    private String refreshToken;
}
