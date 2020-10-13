package com.drypot.sleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class UserMapJsonLoaderTest {

    @Autowired
    private JsonConfig config;

    @Test
    public void canLoadUserMapFromJsonConfig() {
        UserMap map = UserMapJsonLoader.loadFrom(config.getNode("users"));
        User u;

        u = map.get("user");
        assertThat(u.getName()).isEqualTo("user");
        assertThat(u.getHash()).isEqualTo("$2a$10$ku7nymS.1CPd8jMttYXZMe4wVWweWr1EqaYst75tzimQh2iAAqvZW");
        assertThat(u.isAdmin()).isFalse();

        u = map.get("admin");
        assertThat(u.getName()).isEqualTo("admin");
        assertThat(u.getHash()).isEqualTo("$2a$10$vIl4m5eO71dCHQmZH7/BxOwLIHZ/9NYASyosTHgtLEO/MRlCATU9S");
        assertThat(u.isAdmin()).isTrue();

        u = map.get("snowman");
        assertThat(u).isNull();
    }

}
