package com.drypot.sleek.dao.mysql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MySqlThreadTest {

    @Autowired
    JdbcTemplate template;

    @Test
    void tableExists() throws SQLException {
        ResultSet rs = template.getDataSource().getConnection().getMetaData().getColumns(null, null, "thread", null);
        assertThat(rs.next()).isTrue();
    }


}
