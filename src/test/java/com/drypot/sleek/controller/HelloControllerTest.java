package com.drypot.sleek.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@ActiveProfiles("test")
class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void hello() throws Exception {
        mockMvc.perform(get("/api/hello"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("text/plain; charset=UTF-8"))
            .andExpect(content().string("hello"));
    }

    @Test
    void helloJson() throws Exception {
        mockMvc.perform(get("/api/hello-json"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$").value("hello"));
    }

    @Test
    void helloObject() throws Exception {
        mockMvc.perform(get("/api/hello-object?name=snowman&age=10"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.name").value("snowman"))
            .andExpect(jsonPath("$.age").value("10"));
    }

    @Test
    void helloObject2() throws Exception {
        mockMvc.perform(get("/api/hello-object?name=snowman&age=10&extra=blueman"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.name").value("snowman"))
            .andExpect(jsonPath("$.age").value("10"));
    }

    @Test
    void helloObject3() throws Exception {
        mockMvc.perform(get("/api/hello-object"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.name").value("anonymous"))
            .andExpect(jsonPath("$.age").value("1"));
    }

    @Test
    void helloObject4() throws Exception {
        mockMvc.perform(get("/api/hello-object/bluecandy"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.name").value("anonymous"))
            .andExpect(jsonPath("$.nickName").value("bluecandy"))
            .andExpect(jsonPath("$.age").value("1"));
    }

    @Test
    void echo() throws Exception {
        mockMvc.perform(get("/api/echo/melody"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.echo").value("melody"));
    }

    @Test
    void echoDefault() throws Exception {
        mockMvc.perform(get("/api/echo"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.echo").value(""));
    }
}
