package com.dandelion.automationportal.support;

public class TestEntity {

    private int dataBasePort;
    private String dataBaseName;

    public TestEntity(TestPropertyService testPropertyService) {
        this.dataBasePort = testPropertyService.getDatabasePort();
        this.dataBaseName = testPropertyService.getDatabaseName();
    }

    public int getDataBasePort() {
        return dataBasePort;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }
}
