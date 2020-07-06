package com.drypot.sleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostTest {

    @Test
    @DisplayName("we can create post")
    public void createPost() {
        Post p = new Post();
        assertEquals(0, p.getId());
    }

    @Test
    @DisplayName("we can create post with builder")
    public void createPostWithBuilder() {
        Post p = Post.builder().id(10).text("hello").build();
        assertEquals(10, p.getId());
        assertEquals("hello", p.getText());
    }

    @Test
    @DisplayName("we can set post properties")
    public void setProperties() {
        Post p = new Post();

        assertEquals(0, p.getId());
        p.setId(10);
        assertEquals(10, p.getId());

        assertEquals(null, p.getText());
        p.setText("hello");
        assertEquals("hello", p.getText());
    }

    // TODO: test addFileName, removeFileName

}
