package com.happiness.domain.security.auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.happiness.domain.user.dto.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long userSeq;
    private String userId;
    private String userMail;
    private String userNm;

    @JsonIgnore
    private String userPw;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String userId, String userMail, String userPw, String userNm,
                           Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.userMail = userMail;
        this.userPw = userPw;
        this.userNm = userNm;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(UserDto userDto) {
        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));

        return new UserDetailsImpl(userDto.getUserId(), userDto.getUserMail(),
                userDto.getUserPw(), userDto.getUserNm(), authorities);
    }

    public Long getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(Long userSeq) {
        this.userSeq = userSeq;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    @Override
    public String getPassword() {
        return userPw;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}