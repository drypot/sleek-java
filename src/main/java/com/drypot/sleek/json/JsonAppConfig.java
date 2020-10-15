package com.drypot.sleek.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonAppConfig {

    private JsonNode rootNode;

    public JsonAppConfig(String profile) throws IOException {
        ObjectMapper m = new ObjectMapper();
        rootNode = m.readTree(new File("config/config-" + profile + ".json"));
    }

    public JsonNode getNode(String path) {
        return rootNode.get(path);
    }
}
