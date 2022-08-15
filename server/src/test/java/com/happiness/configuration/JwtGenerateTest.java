package com.happiness.configuration;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

@Slf4j
public class JwtGenerateTest {
    private static final String secretKey = "secretKey"; // Token 체크시 필요한 암호키
    private int tokenExpirationMsec = 1800000; // 1800000 30분

    @Test
    public void makeJwtToken() throws InterruptedException {
        // Token 생성
        String token = generateJwtToken("admin");
        Assertions.assertNotNull(token);

//        token += "JwtException";

        System.out.println("token: " + token);
        // Token 유효성 확인
        boolean result;
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey.getBytes())
                    .parseClaimsJws(token).getBody();
            log.info("claims : {}", claims);
            result = true;
        } catch (ExpiredJwtException e) {   // Token이 만료된 경우 Exception이 발생한다.
            log.error("Token Expired");
            result = false;
        } catch (JwtException e) {        // Token이 변조된 경우 Exception이 발생한다.
            log.error("Token Error");
            result = false;
        }

        Assertions.assertTrue(result);
    }

    public String generateJwtToken(String userId) {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MILLISECOND, tokenExpirationMsec);
        Date expiryDate =  calendar.getTime();

        String token = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer(userId) // 토큰 발급자
                .setIssuedAt(now) // 토큰 생성일
                .setExpiration(expiryDate) // 토큰 만료일 Date 타입
                .claim("id", userId) // 클라이언트 정보
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes()) // 유효성 확인 secretKey
                .compact();

        return token;
    }
}