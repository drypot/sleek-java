package com.drypot.sleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryListTest {

    @Test
    @DisplayName("we can create categoryList")
    void create() {
        CategoryList l = new CategoryList();
    }

    @Test
    @DisplayName("we can add category to categoryList")
    void add() {
        CategoryList l = new CategoryList();
        Category c;

        l.add(new Category(100, "freetalk"));
        l.add(new Category(104, "health"));

        c = l.get(0);
        assertEquals(100, c.getId());
        assertEquals("freetalk", c.getName());

        c = l.get(1);
        assertEquals(104, c.getId());
        assertEquals("health", c.getName());
    }

    @Test
    @DisplayName("we can iterate categoryList")
    void iterate() {
        CategoryList l = new CategoryList();
        Category c = null;
        int count = 0;

        l.add(new Category(100, "freetalk"));
        l.add(new Category(104, "health"));

        for(Category c1 : l) {
            c = c1;
            count++;
        }
        assertEquals(104, c.getId());
        assertEquals("health", c.getName());
    }
}
