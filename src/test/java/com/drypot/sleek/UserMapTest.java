package com.drypot.sleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserMapTest {

    @Test
    @DisplayName("we can create userList")
    void create() {
        UserMap map = new UserMap();
    }

    @Test
    @DisplayName("we can put/get user")
    void putUser() {
        UserMap map = new UserMap();

        User u1 = new User("user1", "hash1", false);
        map.put(u1);
        User g1 = map.get("user1");
        assertEquals("user1", g1.getName());
        assertEquals("hash1", g1.getHash());
        assertEquals(false, g1.isAdmin());

        User u2 = new User("user2", "hash2", true);
        map.put(u2);
        User g2 = map.get("user2");
        assertEquals("user2", g2.getName());
        assertEquals("hash2", g2.getHash());
        assertEquals(true, g2.isAdmin());

        assertEquals(null, map.get("user3"));
    }

    @Test
    @DisplayName("we can load userList from config")
    void loadFromConfig() throws IOException {
        UserLoader config = UserLoader.getDefault();
        UserMap map = UserMap.from(config.getJsonNode("users"));
        User u;

        u = map.get("user");
        assertEquals("user", u.getName());
        assertEquals("$2a$10$ku7nymS.1CPd8jMttYXZMe4wVWweWr1EqaYst75tzimQh2iAAqvZW", u.getHash());
        assertFalse(u.isAdmin());

        u = map.get("admin");
        assertEquals("admin", u.getName());
        assertEquals("$2a$10$vIl4m5eO71dCHQmZH7/BxOwLIHZ/9NYASyosTHgtLEO/MRlCATU9S", u.getHash());
        assertTrue(u.isAdmin());

        u = map.get("snowman");
        assertNull(u);
    }

    @Test
    @DisplayName("we can use default UserMap")
    void getDefault() throws IOException {
        UserMap map = UserMap.getDefault();
        User u;

        u = map.get("user");
        assertEquals("user", u.getName());
        assertEquals("$2a$10$ku7nymS.1CPd8jMttYXZMe4wVWweWr1EqaYst75tzimQh2iAAqvZW", u.getHash());
        assertFalse(u.isAdmin());

        u = map.get("snowman");
        assertNull(u);
    }

    @Test
    @DisplayName("we can find user with password")
    void findWithPassword() throws IOException {
        UserMap map = UserMap.getDefault();
        User u;

        u = map.findWithPassword("1");
        assertEquals("user", u.getName());

        u = map.findWithPassword("2");
        assertEquals("cheater", u.getName());

        u = map.findWithPassword("3");
        assertEquals("admin", u.getName());

        u = map.findWithPassword("4");
        assertNull(u);
    }
}
