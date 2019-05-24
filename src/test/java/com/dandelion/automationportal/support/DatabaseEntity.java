package com.dandelion.automationportal.support;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseEntity {

    @Value("${spring.data.mongodb.host}")
    private String dataBaseHost;

    @Value("${spring.data.mongodb.port}")
    private int dataBasePort;

    @Value("${spring.data.mongodb.database}")
    private String dataBaseName;

    public DatabaseEntity() {
    }

    public int getDataBasePort() {
        return dataBasePort;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public String getDataBaseHost() {
        return dataBaseHost;
    }
}
