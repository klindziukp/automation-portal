package com.dandelion.automationportal.script.service;

public class TestEntity {

    private int dataBasePort;
    private String getDataBaseName;

    public TestEntity(int dataBasePort, String getDataBaseName) {
        this.dataBasePort = dataBasePort;
        this.getDataBaseName = getDataBaseName;
    }

    public int getDataBasePort() {
        return dataBasePort;
    }

    public void setDataBasePort(int dataBasePort) {
        this.dataBasePort = dataBasePort;
    }

    public String getGetDataBaseName() {
        return getDataBaseName;
    }

    public void setGetDataBaseName(String getDataBaseName) {
        this.getDataBaseName = getDataBaseName;
    }
}
