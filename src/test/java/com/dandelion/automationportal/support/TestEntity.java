package com.dandelion.automationportal.support;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestEntity {

    @Value("${spring.data.mongodb.port}")
    private int dataBasePort;

    @Value("${spring.data.mongodb.database}")
    private String dataBaseName;

    public TestEntity() {
    }

    public int getDataBasePort() {
        return dataBasePort;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }
}
