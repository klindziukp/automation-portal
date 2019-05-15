package com.dandelion.automationportal.support;

public class TestEntity {

    private int dataBasePort;
    private String getDataBaseName;

    public TestEntity(TestPropertyService testPropertyService) {
        this.dataBasePort = testPropertyService.getDatabasePort();
        this.getDataBaseName = testPropertyService.getDatabaseName();
    }

    public int getDataBasePort() {
        return dataBasePort;
    }

    public String getGetDataBaseName() {
        return getDataBaseName;
    }
}
