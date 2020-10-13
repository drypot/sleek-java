package com.drypot.sleek;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void canCreateUser() {
        User u = new User();
        assertThat(u.getName()).isNull();
        assertThat(u.getHash()).isNull();
        assertThat(u.isAdmin()).isFalse();
    }

    @Test
    void canSetProperties() {
        User u = new User();
        u.setName("snowman");
        u.setHash("####");
        u.setAdmin(true);
        assertThat(u.getName()).isEqualTo("snowman");
        assertThat(u.getHash()).isEqualTo("####");
        assertThat(u.isAdmin()).isTrue();
    }

}
