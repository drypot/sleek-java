package com.drypot.sleek.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostThreadTest {

    @Test
    @DisplayName("we can create postThread")
    public void createPost() {
        PostThread t = new PostThread();
        assertEquals(0, t.getId());
    }

}
