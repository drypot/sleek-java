package com.drypot.sleek;

import org.junit.jupiter.api.Test;

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

}
