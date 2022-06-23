package com.happiness.interfaces.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoginRequest {
    @NotNull
    private String userId;
    @NotNull
    private String userPw;
}
