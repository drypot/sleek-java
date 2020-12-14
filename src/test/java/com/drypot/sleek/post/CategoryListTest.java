package com.drypot.sleek.post;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryListTest {

    @Test
    void canCreateCategoryList() {
        CategoryList l = new CategoryList();
    }

    @Test
    void canAddToCategoryList() {
        CategoryList l = new CategoryList();
        Category c;

        l.add(new Category(100, "freetalk"));
        l.add(new Category(104, "health"));

        c = l.get(0);
        assertThat(c.getId()).isEqualTo(100);
        assertThat(c.getName()).isEqualTo("freetalk");

        c = l.get(1);
        assertThat(c.getId()).isEqualTo(104);
        assertThat(c.getName()).isEqualTo("health");
    }

    @Test
    void canIterateCategoryList() {
        CategoryList l = new CategoryList();
        Category c = null;
        int count = 0;

        l.add(new Category(100, "freetalk"));
        l.add(new Category(104, "health"));

        for(Category c1 : l) {
            c = c1;
            count++;
        }
        assertThat(c.getId()).isEqualTo(104);
        assertThat(c.getName()).isEqualTo("health");
        assertThat(count).isEqualTo(2);
    }

    @Test
    void canTestContains() {
        CategoryList l = new CategoryList();
        l.add(new Category(100, "freetalk"));
        l.add(new Category(104, "health"));

        assertThat(l.contains(100)).isTrue();
        assertThat(l.contains(104)).isTrue();
        assertThat(l.contains(300)).isFalse();
    }
}
