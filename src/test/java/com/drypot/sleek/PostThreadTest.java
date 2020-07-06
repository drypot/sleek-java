package com.drypot.sleek;

import com.drypot.sleek.PostThread;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostThreadTest {

    @Test
    @DisplayName("we can create postThread")
    public void createPost() {
        PostThread t = new PostThread();
        assertEquals(0, t.getId());
    }

}
