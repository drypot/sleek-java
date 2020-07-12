package com.drypot.sleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("we can create user")
    void create() {
        User u = new User();
        assertEquals(null, u.getName());
        assertEquals(null, u.getHash());
        assertEquals(false, u.isAdmin());
    }

    @Test
    @DisplayName("we can set properties")
    void setProperties() {
        User u = new User();
        u.setName("snowman");
        u.setHash("####");
        u.setAdmin(true);
        assertEquals("snowman", u.getName());
        assertEquals("####", u.getHash());
        assertEquals(true, u.isAdmin());
    }
}
