package com.drypot.sleek.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
public class JsonConfig {

    @Autowired
    private Environment env;

    private JsonNode rootNode;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper m = new ObjectMapper();
        rootNode = m.readTree(new File("config/config-" + env.getActiveProfiles()[0] + ".json"));
    }

    public JsonNode getNode(String path) {
        return rootNode.get(path);
    }
}
