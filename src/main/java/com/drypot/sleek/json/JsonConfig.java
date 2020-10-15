package com.drypot.sleek.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.IOException;

@Configuration
public class JsonConfig {

    Logger logger = LoggerFactory.getLogger(JsonConfig.class);

    private final ApplicationContext context;

    private final Environment env;

    public JsonConfig(ApplicationContext context, Environment env) {
        this.context = context;
        this.env = env;
    }

    @Bean
    public JsonAppConfig getJsonConfig() throws IOException {
        return new JsonAppConfig(env.getActiveProfiles()[0]);
    }

}
