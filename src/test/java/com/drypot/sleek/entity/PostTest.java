package com.drypot.sleek.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostTest {

    @Test
    @DisplayName("we can create post")
    public void createPost() {
        Post p = new Post();
        assertEquals(0, p.getId());
    }

    @Test
    void canGetNewId() {
        Post.setIdSeed(10);
        assertThat(Post.getNewId()).isEqualTo(11);
        Post.setIdSeed(20);
        assertThat(Post.getNewId()).isEqualTo(21);
    }

    @Test
    public void canCreatePostWithBuilder() {
        Post p = Post.builder().id(10).text("hello").build();
        assertEquals(10, p.getId());
        assertEquals("hello", p.getText());
    }

    @Test
    public void canSetProperties() {
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
