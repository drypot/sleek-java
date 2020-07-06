package com.drypot.sleek;

import com.drypot.sleek.PostThread;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PostThread")
public class PostThreadSpec {

    @Test
    @DisplayName("we can create no arg postThread")
    public void createPost() {
        PostThread t = new PostThread();
        assertNotNull(t);
    }

}
