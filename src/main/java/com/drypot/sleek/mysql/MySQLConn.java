package com.drypot.sleek.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
public class MySQLConn {

    @Autowired
    Environment env;

    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void init() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(env.getProperty("mysql.url"));
        dataSource.setUsername(env.getProperty("mysql.user"));
        dataSource.setPassword(env.getProperty("mysql.password"));

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource mysqlDataSource() {
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
