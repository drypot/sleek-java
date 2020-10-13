package com.drypot.sleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

public class BCryptTest {

    @Test
    @DisplayName("we can encode password")
    void encode() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode("pass1");
        assertThat(encoded.length()).isEqualTo(60);
    }

    @Test
    @DisplayName("we can match encoded password")
    void match() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode("pass1");
        assertThat(encoder.matches("pass1", encoded)).isTrue();
        assertThat(encoder.matches("passX", encoded)).isFalse();
    }
}
