package com.dandelion.automationportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "vocabulary")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VocabularyItem {

    @Id
    private String id;
    @Indexed(unique = true)
    private String key;
    private String value;
}
