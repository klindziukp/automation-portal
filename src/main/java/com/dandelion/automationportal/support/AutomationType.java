package com.dandelion.automationportal.support;

public enum AutomationType {

    UNIT_TESTING_PROGRAM_NAME("unit", "Unit Testing"),
    API_TESTING_PROGRAM_NAME("api", "Api Testing"),
    WEB_TESTING_PROGRAM_NAME("web", "Web Testing"),
    MOBILE_TESTING_PROGRAM_NAME("mobile", "Mobile Testing"),
    CONNECTED_TV_TESTING_PROGRAM_NAME("connected", "ConnectedTv Testing");

    private String key;
    private String name;

    AutomationType(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public static String getAutomationNameByKey(String key) {
        for (AutomationType automationType : AutomationType.values()) {
            if (automationType.key.equals(key)) {
                return automationType.name;
            }
        }
        throw new RuntimeException(String.format("Unable to get automation with key : '%s'", key));
    }
}
