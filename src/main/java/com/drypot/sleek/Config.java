package com.drypot.sleek;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Config {

    private String appName;
    private int appPort;

    private String cookieSecret;

    private String uploadSite;
    private String uploadDir;

    private String mysqlDatabase;
    private String mysqlUser;
    private String mysqlPassword;

}
