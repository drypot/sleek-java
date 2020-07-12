package com.drypot.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineArgumentsTest {

    @Test
    @DisplayName("we can get config path")
    void configPath() {
        String p = CommandLineArguments.getConfigPath();
        assertEquals("config/test.json", p);
    }
}
