package com.drypot.sleek.dao.mysql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MySQLConfigTest {

    @Autowired
    JdbcTemplate template;

    @Test
    void canUseJdbcTemplate() {
        int i = template.queryForObject("select 11", Integer.class);
        assertThat(i).isEqualTo(11);
    }

}
