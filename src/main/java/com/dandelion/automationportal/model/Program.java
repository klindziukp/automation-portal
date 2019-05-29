package com.dandelion.automationportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "program")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Program {

    @Id
    private String id;
    private String name;
    private List<String> sequence;
    private List<Chapter> chapters;
    private List<Topic> topics;

    public Chapter getChapter(String key) {
        return chapters.stream().
                filter(chapter -> chapter.getKey().equals(key)).findFirst().orElseThrow(
                () -> new RuntimeException(String.format("Unable to get chapter with key : '%s'", key)));
    }

    public Topic getTopic(String key) {
        return topics.stream().
                filter(topic -> topic.getKey().equals(key)).findFirst().orElseThrow(
                () -> new RuntimeException(String.format("Unable to get topic with key : '%s'", key)));
    }
}
