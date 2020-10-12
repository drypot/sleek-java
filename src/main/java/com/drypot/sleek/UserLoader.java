package com.drypot.sleek;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.File;
import java.io.IOException;

@Data
@NoArgsConstructor
public class UserLoader {

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private JsonNode jsonRoot;

    private String appName = "";
    private int appPort;
    private String uploadSite;
    private String uploadDir;
    private String mysqlDatabase;
    private String mysqlUser;
    private String mysqlPassword;

    public JsonNode getJsonNode(String path) {
        return jsonRoot.path(path);
    }

    public static UserLoader from(String f) throws IOException {
        UserLoader c = new UserLoader();
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

    private static UserLoader defaultConfig;
    public static UserLoader getDefault() throws IOException {
        if (defaultConfig == null) {
            defaultConfig = from("");
        }
        return defaultConfig;
    }
}
