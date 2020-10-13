package com.drypot.sleek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class JsonConfigTest {

    @Autowired
    JsonConfig loader;

    @Test
    void loaderExists() {
        assertThat(loader).isNotNull();
    }

    @Test
    void usersNodeExists() {
        assertThat(loader.getNode("users")).isNotNull();
    }

    @Test
    void categoriesNodeExists() {
        assertThat(loader.getNode("categories")).isNotNull();
    }
}
