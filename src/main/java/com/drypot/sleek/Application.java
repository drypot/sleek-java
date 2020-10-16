package com.drypot.sleek;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    Logger logger = LoggerFactory.getLogger(Application.class);

    private final ApplicationContext context;

    private final Environment env;

    public Application(ApplicationContext context, Environment env) {
        this.context = context;
        this.env = env;
        logger.info("app.name = " + env.getProperty("app.name"));
        logger.info("app.port = " + env.getProperty("app.port", Integer.class));
    }

}
