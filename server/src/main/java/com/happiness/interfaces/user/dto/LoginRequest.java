package com.happiness.interfaces.user.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.units.qual.A;

@Getter
@Setter
public class LoginRequest {
    private String userId;
    private String userPw;
}
