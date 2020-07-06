package com.drypot.sleek;

import com.drypot.sleek.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Post")
public class PostSpec {

    @Test
    @DisplayName("we can create no arg post")
    public void createPost() {
        Post p = new Post();
        assertNotNull(p);
    }

    @Test
    @DisplayName("we can create post with builder")
    public void createPostWithBuilder() {
        Post p = Post.builder().id(10).text("hello").build();
        assertNotNull(p);
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
