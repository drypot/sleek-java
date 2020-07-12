package com.drypot.sleek;

import com.drypot.common.Config;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("we can create userList")
    void create() {
        UserList l = new UserList();
    }

    @Test
    @DisplayName("we can put/get user")
    void putUser() {
        UserList l = new UserList();

        User u1 = new User("user1", "hash1", false);
        l.put(u1);
        User g1 = l.get("user1");
        assertEquals("user1", g1.getName());
        assertEquals("hash1", g1.getHash());
        assertEquals(false, g1.isAdmin());

        User u2 = new User("user2", "hash2", true);
        l.put(u2);
        User g2 = l.get("user2");
        assertEquals("user2", g2.getName());
        assertEquals("hash2", g2.getHash());
        assertEquals(true, g2.isAdmin());

        assertEquals(null, l.get("user3"));
    }

    @Test
    @DisplayName("we can load userList from config")
    void loadFromConfig() throws IOException {
        Config c = Config.fromCache();
        UserList l = UserList.from(c.getJsonRoot().get("users"));
        User u;

        u = l.get("user");
        assertEquals("user", u.getName());
        assertEquals("$2a$10$ku7nymS.1CPd8jMttYXZMe4wVWweWr1EqaYst75tzimQh2iAAqvZW", u.getHash());
        assertEquals(false, u.isAdmin());

        u = l.get("admin");
        assertEquals("admin", u.getName());
        assertEquals("$2a$10$vIl4m5eO71dCHQmZH7/BxOwLIHZ/9NYASyosTHgtLEO/MRlCATU9S", u.getHash());
        assertEquals(true, u.isAdmin());

        u = l.get("snowman");
        assertEquals(null, u);
    }
}
