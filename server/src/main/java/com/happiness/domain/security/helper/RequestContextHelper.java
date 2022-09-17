package com.happiness.domain.security.helper;

import com.happiness.domain.user.dto.UserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestContextHelper {

    public static UserDto getLoginUserInfo() {
        return (UserDto) RequestContextHolder.getRequestAttributes().getAttribute("loginUserInfo", RequestAttributes.SCOPE_SESSION);
    }

    public static void setLoginUserInfo(UserDto userDto) {
        RequestContextHolder.getRequestAttributes().setAttribute("loginUserInfo", userDto, RequestAttributes.SCOPE_SESSION);
    }

}
