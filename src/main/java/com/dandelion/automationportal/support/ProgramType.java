package com.dandelion.automationportal.support;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ProgramType {

    UNIT_TESTING_PROGRAM_NAME("unit", "Unit Testing"),
    API_TESTING_PROGRAM_NAME("api", "Api Testing"),
    WEB_TESTING_PROGRAM_NAME("web", "Web Testing"),
    MOBILE_TESTING_PROGRAM_NAME("mobile", "Mobile Testing"),
    CONNECTED_TV_TESTING_PROGRAM_NAME("connected", "ConnectedTv Testing"),
    CODE_REVIEW_PROGRAM_NAME("code-review", "Code Review");

    private String key;
    private String name;

    ProgramType(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public static String getTopicNameByKey(String key) {
      return Stream.of(ProgramType.values())
              .filter(programType -> programType.key.equals(key))
              .map(programType -> programType.name)
              .findAny()
              .orElseThrow(
                      () -> new RuntimeException(String.format("Unable to get automation with key : '%s'", key)));

    }

    public static List<String> getProgramKeys(){
       return Stream.of(ProgramType.values()).map(topicType -> topicType.key).collect(Collectors.toList());
    }
}
