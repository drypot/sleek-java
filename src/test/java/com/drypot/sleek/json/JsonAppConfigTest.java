package com.drypot.sleek.json;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest()
@Import(JsonConfig.class)
@ActiveProfiles("test")
class JsonAppConfigTest {

    @Autowired
    private JsonAppConfig config;

    @Test
    void configShouldExists() {
        assertThat(config).isNotNull();
    }

    @Test
    void usersNodeShouldExists() {
        assertThat(config.getNode("users")).isNotNull();
    }

    @Test
    void categoriesNodeShouldExists() {
        assertThat(config.getNode("categories")).isNotNull();
    }
}
