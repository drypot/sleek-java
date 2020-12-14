package com.drypot.sleek.post;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostThreadTest {

    @Test
    public void canCreate() {
        PostThread t = new PostThread();
        assertEquals(0, t.getId());
    }

    @Test
    void canGetNewId() {
        PostThread.setIdSeed(10);
        assertThat(PostThread.getNewId()).isEqualTo(11);
        PostThread.setIdSeed(20);
        assertThat(PostThread.getNewId()).isEqualTo(21);
    }
}
