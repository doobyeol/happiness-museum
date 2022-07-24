package com.happiness.interfaces.auth.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginRequest {
    @NotNull
    private String userId;
    @NotNull
    private String userPw;
}
