package com.happiness.domain.security.auth;
import com.happiness.domain.user.dto.UserDto;
import com.happiness.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserDto UserDto = userService.findUserById(userId);

        RequestContextHolder.getRequestAttributes().setAttribute("loginUserInfo", UserDto, RequestAttributes.SCOPE_SESSION);

        return UserDetailsImpl.build(UserDto);
    }

}