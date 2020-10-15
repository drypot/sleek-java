package com.drypot.sleek.json;

import com.drypot.sleek.entity.CategoryList;
import com.drypot.sleek.entity.CategoryListMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@Import(JsonConfig.class)
@ActiveProfiles("test")
class JsonCategoryListMapTest {

    @Autowired
    private JsonAppConfig config;

    @Test
    public void canLoadFromJsonConfig() {
        CategoryListMap map = JsonCategoryListMap.loadFrom(config.getNode("categories"));
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
