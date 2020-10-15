package com.drypot.sleek;

import com.drypot.sleek.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.IOException;

@Configuration
public class ApplicationConfig {

    Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

    private final ApplicationContext context;

    private final Environment env;

    public ApplicationConfig(ApplicationContext context, Environment env) {
        this.context = context;
        this.env = env;
        logger.info("app.name = " + env.getProperty("app.name"));
        logger.info("app.port = " + env.getProperty("app.port", Integer.class));
    }

    @Bean
    public JsonConfig getJsonConfig() throws IOException {
        return new JsonConfig(env.getActiveProfiles()[0]);
    }

}
