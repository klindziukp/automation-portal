package com.dandelion.automationportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "howTo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class HowToCategory {

    @Id
    private String id;
    private String name;
    private List<HowToItem> howToItems;
}
