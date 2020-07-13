package com.drypot.sleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    @DisplayName("we can create category")
    void create() {
        Category c = new Category();
        assertEquals(0, c.getId());
        assertEquals(null, c.getName());
    }

    @Test
    @DisplayName("we can set proeprties")
    void setProperties() {
        Category c = new Category();
        c.setId(100);
        c.setName("freetalk");
        assertEquals(100, c.getId());
        assertEquals("freetalk", c.getName());
    }

    @Test
    @DisplayName("we can compare two categories")
    void compare() {
        Category c1 = new Category(100, "freetalk");
        Category c2 = new Category(104, "health");

        assertTrue(c1.equals(c1));
        assertTrue(c1.equals(new Category(100, "freetalk")));
        assertFalse(c2.equals(new Category(100, "freetalk")));
    }
}
