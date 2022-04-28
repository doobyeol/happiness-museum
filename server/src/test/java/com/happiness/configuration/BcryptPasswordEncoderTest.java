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
        String encoded = passwordEncoder.encode("test123");
        log.info("encoded : {}", encoded);

        boolean result = passwordEncoder.matches("test123", "$2a$10$00DU58jNWcIKTyYbjBuH7OEtvbXq5nupCbWWIsykTi4dE08ipxBra");
        log.info("result {}", result);

        Assertions.assertTrue(result);
    }
}
