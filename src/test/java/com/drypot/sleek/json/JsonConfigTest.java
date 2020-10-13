package com.drypot.sleek.json;

import com.drypot.sleek.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes= Application.class)
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
