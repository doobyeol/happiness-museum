package com.happiness.interfaces.auth.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TokenRequest {
    @NotNull
    private String token;
}
