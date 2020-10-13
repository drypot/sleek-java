package com.drypot.sleek.entity;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class UserMapTest {

    @Test
    void canCreateUserList() {
        UserMap map = new UserMap();
    }

    @Test
    void canPutGetUser() {
        UserMap map = new UserMap();

        User u1 = new User("user1", "hash1", false);
        map.put(u1);
        User g1 = map.get("user1");
        assertThat(g1.getName()).isEqualTo("user1");
        assertThat(g1.getHash()).isEqualTo("hash1");
        assertThat(g1.isAdmin()).isFalse();

        User u2 = new User("user2", "hash2", true);
        map.put(u2);
        User g2 = map.get("user2");
        assertThat(g2.getName()).isEqualTo("user2");
        assertThat(g2.getHash()).isEqualTo("hash2");
        assertThat(g2.isAdmin()).isTrue();

        assertThat(map.get("user3")).isNull();
    }

    @Test
    void canFindUserWithPassword() throws IOException {
        UserMap map = new UserMap();
        User u;

        u = new User("user", "$2a$10$ku7nymS.1CPd8jMttYXZMe4wVWweWr1EqaYst75tzimQh2iAAqvZW", false);
        map.put(u);

        u = new User("cheater", "$2a$10$ZXzPk9TDWLTbdUt4A3KAXOVK5ed5zsnRHiGeGExA5xSVvD3ZWURDK", false);
        map.put(u);

        u = new User("admin", "$2a$10$vIl4m5eO71dCHQmZH7/BxOwLIHZ/9NYASyosTHgtLEO/MRlCATU9S", true);
        map.put(u);

        u = map.findWithPassword("1");
        assertThat(u.getName()).isEqualTo("user");

        u = map.findWithPassword("2");
        assertThat(u.getName()).isEqualTo("cheater");

        u = map.findWithPassword("3");
        assertThat(u.getName()).isEqualTo("admin");

        u = map.findWithPassword("4");
        assertThat(u).isNull();
    }
}
