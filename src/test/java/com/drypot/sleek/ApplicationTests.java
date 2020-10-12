package com.drypot.sleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

    @Autowired
    Environment environment;

    @Test
    @DisplayName("True should be true")
    void trueShouldBeTrue() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Profile should be test")
    void profileShouldBeTest() {
        assertThat(environment.getActiveProfiles()[0]).isEqualTo("test");
    }

    @Test
    @DisplayName("App name should be test")
    void appNameShouldBeTest() {
        assertThat(environment.getProperty("app.name")).isEqualTo("sleek test");
    }
}
