package com.drypot.sleek.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Post")
public class PostTest {

    @Test
    @DisplayName("can be created")
    public void create() {
        Post p = Post.of();
        assertNotNull(p);
    }

    @Test
    @DisplayName("can be set properties")
    public void createWithBuilder() {
        Post p = Post.of();

        assertEquals(0, p.getId());
        p.setId(10);
        assertEquals(10, p.getId());

        assertEquals(null, p.getText());
        p.setText("hello");
        assertEquals("hello", p.getText());
    }

    // TODO: test addFileName, removeFileName

}
