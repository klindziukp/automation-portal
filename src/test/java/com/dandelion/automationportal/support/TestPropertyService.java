package com.dandelion.automationportal.support;

import java.util.ResourceBundle;

public final class TestPropertyService {

    private ResourceBundle resourceBundle;

    public TestPropertyService(String propertiesName) {
        resourceBundle = ResourceBundle.getBundle(propertiesName);
    }

    public String getDatabaseName() {
        return this.resourceBundle.getString("spring.data.mongodb.database");
    }

    public int getDatabasePort() {
        return Integer.valueOf(this.resourceBundle.getString("spring.data.mongodb.port"));
    }
}



