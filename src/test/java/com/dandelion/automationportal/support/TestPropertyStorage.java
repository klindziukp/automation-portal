package com.dandelion.automationportal.support;

import java.util.ResourceBundle;

public final class TestPropertyStorage {

    public static final String DATABASE_NAME;
    public static final int DATABASE_CONNECTION_PORT;

    private static ResourceBundle resourceBundle;

    static {
        resourceBundle = ResourceBundle.getBundle("application-test");
        DATABASE_NAME = getDatabaseName();
        DATABASE_CONNECTION_PORT = getDatabasePort();
    }

    private TestPropertyStorage() {
    }

    private static String getDatabaseName() {
        return resourceBundle.getString("spring.data.mongodb.database");
    }

    private static int getDatabasePort() {
        return Integer.valueOf(resourceBundle.getString("spring.data.mongodb.port"));
    }
}



