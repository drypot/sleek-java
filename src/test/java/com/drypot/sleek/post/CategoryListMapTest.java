package com.drypot.sleek.post;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryListMapTest {

    @Test
    void canCreateCategoryListMap() {
        CategoryListMap map = new CategoryListMap();
    }

    @Test
    void canPutToCategoryListMap() {
        CategoryListMap map = new CategoryListMap();
        CategoryList l1 = new CategoryList();
        CategoryList l2 = new CategoryList();

        map.put("user1", l1);
        map.put("user2", l2);

        assertThat(map.get("user1")).isEqualTo(l1);
        assertThat(map.get("user2")).isEqualTo(l2);
    }

}
