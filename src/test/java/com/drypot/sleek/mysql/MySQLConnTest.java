package com.drypot.sleek.mysql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class MySQLConnTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate template;

    @Test
    void canGetDatasource() {
        assertThat(dataSource).isNotNull();
    }

    @Test
    void canUseTemplate() {
        int i = template.queryForObject("select 11", Integer.class);
        assertThat(i).isEqualTo(11);
    }
}
