package com.drypot.sleek.controller;

import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping(value = "/api/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    String hello() {
        return "hello";
    }

    @GetMapping(value = "/api/hello-json", produces = MediaType.APPLICATION_JSON_VALUE)
    String helloJson() {
        return "hello";
    }

    @GetMapping(value = "/api/hello-object", produces = MediaType.APPLICATION_JSON_VALUE)
    HelloForm helloObject(HelloForm form) {
        return form;
    }

    @GetMapping(value = "/api/hello-object/{nickName}", produces = MediaType.APPLICATION_JSON_VALUE)
    HelloForm helloObjectNickName(HelloForm form) {
        return form;
    }

    @Data
    public class HelloForm {
        String name = "anonymous";
        String nickName = "";
        int age = 1;
    }

    @GetMapping(value = { "/api/echo", "/api/echo/{param}" })
    Map<String, String> echo(@PathVariable(required = false) String param) {
        return Collections.singletonMap("echo", param == null ? "" : param);
    }

}
