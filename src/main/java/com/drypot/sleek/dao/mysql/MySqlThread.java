package com.drypot.sleek.dao.mysql;

import com.drypot.sleek.post.PostThread;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlThread implements CommandLineRunner {

    private final JdbcTemplate template;

    public MySqlThread(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void run(String... args) throws Exception {
        Integer maxId = template.queryForObject("select coalesce(max(id), 0) as maxId from thread", Integer.class);
        PostThread.setIdSeed(maxId);
    }


}
