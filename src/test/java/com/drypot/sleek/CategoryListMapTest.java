package com.drypot.sleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CategoryListMapTest {

    @Test
    @DisplayName("we can create categoryListMap")
    void create() {
        CategoryListMap map = new CategoryListMap();
    }

    @Test
    @DisplayName("we can put categoryList")
    void add() {
        CategoryListMap map = new CategoryListMap();
        CategoryList l1 = new CategoryList();
        CategoryList l2 = new CategoryList();

        map.put("user1", l1);
        map.put("user2", l2);

        assertEquals(l1, map.get("user1"));
        assertEquals(l2, map.get("user2"));
    }

    @Test
    @DisplayName("we can load categoryListMap from Json")
    void loadFromJson() throws IOException {
        UserLoader config = UserLoader.getDefault();
        CategoryListMap map = CategoryListMap.from(config.getJsonNode("categories"));
        CategoryList l;

        l = map.get("user");
        assertTrue(l.contains(100));
        assertTrue(l.contains(104));
        assertFalse(l.contains(60));
        assertFalse(l.contains(40));

        l = map.get("cheater");
        assertTrue(l.contains(100));
        assertTrue(l.contains(104));
        assertTrue(l.contains(60));
        assertFalse(l.contains(40));
    }

    @Test
    @DisplayName("we can use default categoryListMap")
    void useDefaultMap() throws IOException {
        CategoryListMap map = CategoryListMap.getDefault();
        CategoryList l;

        l = map.get("user");
        assertTrue(l.contains(100));
        assertTrue(l.contains(104));
        assertFalse(l.contains(60));
        assertFalse(l.contains(40));
    }
}
