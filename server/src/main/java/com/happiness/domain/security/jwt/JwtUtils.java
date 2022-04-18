package com.happiness.domain.security.jwt;

import java.util.Date;

import com.happiness.domain.security.auth.UserDetailsImpl;
import com.happiness.domain.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Component
public class JwtUtils {

    @Value("${happiness.app.jwt-secret}")
    private String jwtSecret;

    @Value("${happiness.app.jwt-expiration-ms}")
    private int jwtExpirationMs;

    @Value("${happiness.app.rjwt-expiration-ms}")
    private int rjwtExpirationMs;

    @Value("${spring.profiles.active:}")
    private String activeProfile;

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        String jwtToken = "";
        if("local".equals(activeProfile) || "dev".equals(activeProfile)) {
            jwtToken = Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
        } else {
            jwtToken = Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                    .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
        }
        return jwtToken;
    }

    public String generateJwtToken(String token) {
        String username = getUserNameFromJwtToken(token);

        String jwtToken = "";
        if("local".equals(activeProfile) || "dev".equals(activeProfile)) {
            jwtToken = Jwts.builder().setSubject((username)).setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
        } else {
            jwtToken = Jwts.builder().setSubject((username)).setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                    .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
        }
        return jwtToken;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }


    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public String generateRefreshJwtToken(String token) {
        String username = getUserNameFromJwtToken(token);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + rjwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }


    public UserDto getLoginUserEntity() {
        return (UserDto)RequestContextHolder.getRequestAttributes().getAttribute("loginUserInfo", RequestAttributes.SCOPE_SESSION);
    }
}