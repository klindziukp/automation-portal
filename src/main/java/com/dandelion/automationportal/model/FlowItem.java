package com.dandelion.automationportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "flow")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlowItem {

    @Id
    private String id;
    @Indexed(unique = true)
    private Integer number;
    private String step;
}
