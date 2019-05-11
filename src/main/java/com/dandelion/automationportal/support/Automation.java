package com.dandelion.automationportal.support;

public enum Automation {

    UNIT_TESTING_PROGRAM_NAME("unit", "Unit Testing"),
    API_TESTING_PROGRAM_NAME("api", "Api Testing"),
    UI_TESTING_PROGRAM_NAME("ui", "Ui Testing"),
    MOBILE_TESTING_PROGRAM_NAME("mobile", "Mobile Testing"),
    CONNECTED_TV_TESTING_PROGRAM_NAME("connected", "ConnectedTv Testing");

    private String key;
    private String name;

    Automation(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public static String getAutomationNameByKey(String key) {
        for (Automation automation : Automation.values()) {
            if (automation.key.equals(key)) {
                return automation.name;
            }
        }
        throw new RuntimeException(String.format("Unable to get automation with key : '%s'", key));
    }
}
