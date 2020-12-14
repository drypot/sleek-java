package com.drypot.sleek.post;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryTest {

    @Test
    void canCreateCategory() {
        Category c = new Category();
        assertThat(c.getId()).isEqualTo(0);
        assertThat(c.getName()).isNull();
    }

    @Test
    void canSetProperties() {
        Category c = new Category();
        c.setId(100);
        c.setName("freetalk");
        assertThat(c.getId()).isEqualTo(100);
        assertThat(c.getName()).isEqualTo("freetalk");
    }

    @Test
    void canCompareTwoCategoreis() {
        Category c1 = new Category(100, "freetalk");
        Category c2 = new Category(104, "health");

        assertThat(c1.equals(c1)).isTrue();
        assertThat(c1.equals(new Category(100, "freetalk"))).isTrue();
        assertThat(c2.equals(new Category(100, "freetalk"))).isFalse();
    }
}
