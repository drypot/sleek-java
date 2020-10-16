package com.drypot.sleek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = EmptyConfig.class)
@ActiveProfiles("test")
class ApplicationTests {

    @Autowired
    ApplicationContext context;

    @Autowired
    Environment env;

    @Test
    void trueShouldBeTrue() {
        assertThat(true).isTrue();
    }

    @Test
    void contextShouldBeExists() {
        assertThat(context).isNotNull();
    }

    @Test
    void envShouldBeExists() {
        assertThat(env).isNotNull();
    }

    @Test
    void profileShouldBeTest() {
        assertThat(env.getActiveProfiles()[0]).isEqualTo("test");
    }

    @Test
    void appNameShouldBeTest() {
        assertThat(env.getProperty("app.name")).isEqualTo("sleek test");
    }
}
