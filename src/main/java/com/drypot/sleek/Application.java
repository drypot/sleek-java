package com.drypot.sleek;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private final ApplicationContext context;

    private final Environment env;

    public Application(ApplicationContext context, Environment env) {
        this.context = context;
        this.env = env;
        log.info("app.name = " + env.getProperty("app.name"));
    }

}
