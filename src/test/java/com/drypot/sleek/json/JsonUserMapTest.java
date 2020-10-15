package com.drypot.sleek.json;

import com.drypot.sleek.entity.User;
import com.drypot.sleek.entity.UserMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@Import(JsonConfig.class)
@ActiveProfiles("test")
public class JsonUserMapTest {

    @Autowired
    private JsonAppConfig config;

    @Test
    public void canLoadFromJsonConfig() {
        UserMap map = JsonUserMap.loadFrom(config.getNode("users"));
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
