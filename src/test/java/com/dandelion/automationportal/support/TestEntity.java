package com.dandelion.automationportal.support;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class TestEntity {

    @Value("${spring.data.mongodb.port}")
    private int dataBasePort;

    @Value("${spring.data.mongodb.database}")
    private String getDataBaseName;

    public TestEntity() {
//        this.dataBasePort = testPropertyService.getDatabasePort();
//        this.getDataBaseName = testPropertyService.getDatabaseName();
    }

    public int getDataBasePort() {
        return dataBasePort;
    }

    public String getGetDataBaseName() {
        return getDataBaseName;
    }
}
