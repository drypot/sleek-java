package com.drypot.sleek.upload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class BasicUploadStorage {

    private static final Logger log = LoggerFactory.getLogger(BasicUploadStorage.class);

    private final Environment env;
    private final String url;
    private final String dir;

    public BasicUploadStorage(Environment env) {
        this.env = env;
        url = env.getProperty("app.upload.url");
        dir = env.getProperty("app.upload.dir");
    }

    @PostConstruct
    public void init() throws IOException {
        //multipartResolver.setUploadTempDir(new FileSystemResource(fileServerRootDir + "/upload-temp"));
        log.info("Upload files url: " + url);
        log.info("Upload files directory: " + dir);
    }

}
