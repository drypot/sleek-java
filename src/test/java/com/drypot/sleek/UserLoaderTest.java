package com.drypot.sleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class UserLoaderTest {

    @Test
    @DisplayName("we can create config")
    public void create() {
        UserLoader c = new UserLoader();
        assertEquals("", c.getAppName());
    }

    @Test
    @DisplayName("we can set properties")
    public void setProperties() {
        UserLoader c = new UserLoader();
        c.setAppName("new name");
        assertEquals("new name", c.getAppName());
    }

    @Test
    @DisplayName("we can load config from file")
    public void loadConfigFromFile() throws IOException {
        UserLoader c = UserLoader.from("");
        assertEquals("app test", c.getAppName());
        assertEquals(8001, c.getAppPort());
        assertEquals("http://file.sleek.dev:8080", c.getUploadSite());
        assertEquals("upload/sleek-test", c.getUploadDir());
        assertEquals("sleek_test", c.getMysqlDatabase());
        assertEquals("drypot", c.getMysqlUser());
        assertEquals("", c.getMysqlPassword());
    }

    @Test
    @DisplayName("we can get default config")
    public void loadConfigFromCache() throws IOException {
        UserLoader c = UserLoader.getDefault();
        assertEquals("app test", c.getAppName());
        assertEquals(8001, c.getAppPort());
        assertEquals("http://file.sleek.dev:8080", c.getUploadSite());
        assertEquals("upload/sleek-test", c.getUploadDir());
        assertEquals("sleek_test", c.getMysqlDatabase());
        assertEquals("drypot", c.getMysqlUser());
        assertEquals("", c.getMysqlPassword());
    }

    @Test
    @DisplayName("we can use getJsonNode")
    void getJsonNode() throws IOException {
        UserLoader c = UserLoader.getDefault();
        assertEquals("app test", c.getJsonNode("appName").asText());
        assertEquals(8001, c.getJsonNode("appPort").asInt());
    }
}
