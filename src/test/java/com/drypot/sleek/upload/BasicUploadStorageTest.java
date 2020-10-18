package com.drypot.sleek.upload;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = BasicUploadStorage.class)
@ActiveProfiles("test")
class BasicUploadStorageTest {

    @Test
    void shouldSuccess() {
        assertThat(true).isTrue();
    }
}
