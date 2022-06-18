package com.happiness.configuration;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
public class BcryptPasswordEncoderTest {

    @Test
    public void testEncode() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encoded = passwordEncoder.encode("1234");
        log.info("encoded : {}", encoded);

        boolean result = passwordEncoder.matches("1234", "$2a$10$4wonBcMqO2RI581XCz0LT.BCLoE/sI2nTzQ.ZBW/03RhYAMAh1YVm");
        log.info("result {}", result);

        Assertions.assertTrue(result);
    }
}
