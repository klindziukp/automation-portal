package com.dandelion.automationportal.support;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TopicType {

    UNIT_TESTING_PROGRAM_NAME("unit", "Unit Testing"),
    API_TESTING_PROGRAM_NAME("api", "Api Testing"),
    WEB_TESTING_PROGRAM_NAME("web", "Web Testing"),
    MOBILE_TESTING_PROGRAM_NAME("mobile", "Mobile Testing"),
    CONNECTED_TV_TESTING_PROGRAM_NAME("connected", "ConnectedTv Testing"),
    CODE_REVIEW_PROGRAM_NAME("code-review", "Code Review");

    private String key;
    private String name;

    TopicType(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public static String getTopicNameByKey(String key) {
      return Stream.of(TopicType.values())
              .filter(topicType -> topicType.key.equals(key))
              .map(topicType -> topicType.name)
              .findAny()
              .orElseThrow(
                      () -> new RuntimeException(String.format("Unable to get automation with key : '%s'", key)));

    }

    public static List<String> getAutomationKeys(){
       return Stream.of(TopicType.values()).map(topicType -> topicType.key).collect(Collectors.toList());
    }
}
