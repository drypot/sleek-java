package com.drypot.sleek.dao.mysql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(MySqlConfig.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MySqlConfigTest {

    @Autowired
    Environment env;

    @Autowired
    JdbcTemplate template;

    @Test
    void canUseJdbcTemplate() {
        int i = template.queryForObject("select 11", Integer.class);
        assertThat(i).isEqualTo(11);
    }

    @Test
    void dbnameShouldBe() {
        String dbname = template.queryForObject("select database()", String.class);
        assertThat(dbname).isEqualTo(env.getProperty("app.dbname"));
    }
}
