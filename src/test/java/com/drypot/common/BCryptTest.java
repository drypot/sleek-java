package com.drypot.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

public class BCryptTest {

    @Test
    @DisplayName("we can encode password")
    void encode() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode("pass1");
        assertEquals(60, encoded.length());
    }

    @Test
    @DisplayName("we can match encoded password")
    void match() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode("pass1");
        assertTrue(encoder.matches("pass1", encoded));
        assertFalse(encoder.matches("passX", encoded));
    }
}
