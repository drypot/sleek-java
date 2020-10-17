package com.drypot.sleek.dao.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class MySqlConfig {

    private static final Logger log = LoggerFactory.getLogger(MySqlConfig.class);

    private final Environment env;
    private final JdbcTemplate template;

    @Autowired
    public MySqlConfig(Environment env, JdbcTemplate template) {
        this.env = env;
        this.template = template;
    }

}
