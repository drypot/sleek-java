package com.drypot.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;

@Data
@NoArgsConstructor
public class Config {
    private JsonNode jsonRoot;
    private String appName = "";
    private int appPort;
    private String uploadSite;
    private String uploadDir;
    private String mysqlDatabase;
    private String mysqlUser;
    private String mysqlPassword;

    public static Config from(String f) throws IOException {
        Config c = new Config();
        ObjectMapper m = new ObjectMapper();
        c.jsonRoot = m.readTree(new File(f));
        c.setAppName(c.jsonRoot.get("appName").asText());
        c.setAppPort(c.jsonRoot.get("appPort").asInt());
        c.setUploadSite(c.jsonRoot.get("uploadSite").asText());
        c.setUploadDir(c.jsonRoot.get("uploadDir").asText());
        c.setMysqlDatabase(c.jsonRoot.get("mysqlDatabase").asText());
        c.setMysqlUser(c.jsonRoot.get("mysqlUser").asText());
        c.setMysqlPassword(c.jsonRoot.get("mysqlPassword").asText());
        return c;
    }
}
