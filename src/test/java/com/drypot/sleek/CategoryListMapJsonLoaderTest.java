package com.drypot.sleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class CategoryListMapJsonLoaderTest {

    @Autowired
    private JsonConfig config;

    @Test
    public void canLoadFromJsonConfig() {
        CategoryListMap map = CategoryListMapJsonLoader.loadFrom(config.getNode("categories"));
        CategoryList l;

        l = map.get("user");
        assertThat(l.contains(100)).isTrue();
        assertThat(l.contains(104)).isTrue();
        assertThat(l.contains(60)).isFalse();
        assertThat(l.contains(40)).isFalse();

        l = map.get("cheater");
        assertThat(l.contains(100)).isTrue();
        assertThat(l.contains(104)).isTrue();
        assertThat(l.contains(60)).isTrue();
        assertThat(l.contains(40)).isFalse();
    }

}
