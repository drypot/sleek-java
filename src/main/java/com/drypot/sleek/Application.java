package com.drypot.sleek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        ApplicationContext context = app.run(args);
        Environment env = context.getEnvironment();
        System.out.println("app.name = " + env.getProperty("app.name"));
        System.out.println("app.port = " + env.getProperty("app.port", Integer.class));
    }
}
