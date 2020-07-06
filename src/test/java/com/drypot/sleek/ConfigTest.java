package com.drypot.sleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Config")
public class ConfigTest {

    @Test
    @DisplayName("we can create config")
    public void create() {
        Config c = new Config();
        assertEquals(null, c.getAppName());
    }

    @Test
    @DisplayName("we can set properties")
    public void setProperties() {
        Config c = new Config();
        assertEquals(null, c.getAppName());
        c.setAppName("new app");
        assertEquals("new app", c.getAppName());
    }
}
