package com.drypot.common;

import com.drypot.common.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigTest {

    @Test
    @DisplayName("we can create config")
    public void create() {
        Config c = new Config();
        assertEquals("", c.getAppName());
    }

    @Test
    @DisplayName("we can set properties")
    public void setProperties() {
        Config c = new Config();
        c.setAppName("new name");
        assertEquals("new name", c.getAppName());
    }

    @Test
    @DisplayName("we can load config from file")
    public void loadConfigFromFile() throws IOException {
        Config c = Config.from(CommandLineArguments.getConfigPath());
        assertEquals("sleek test", c.getAppName());
        assertEquals(8001, c.getAppPort());
        assertEquals("http://file.sleek.dev:8080", c.getUploadSite());
        assertEquals("upload/sleek-test", c.getUploadDir());
        assertEquals("sleek_test", c.getMysqlDatabase());
        assertEquals("drypot", c.getMysqlUser());
        assertEquals("", c.getMysqlPassword());
    }
}
