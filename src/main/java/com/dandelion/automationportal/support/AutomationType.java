package com.dandelion.automationportal.support;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
      return Stream.of(AutomationType.values())
              .filter(automationType -> automationType.key.equals(key))
              .map(automationType -> automationType.name)
              .findAny()
              .orElseThrow(() ->new RuntimeException(String.format("Unable to get automation with key : '%s'", key)));

    }

    public static List<String> getAutomationKeys(){
       return Stream.of(AutomationType.values()).map(automationType -> automationType.key).collect(Collectors.toList());
    }
}
