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
}
