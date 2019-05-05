package com.dandelion.automationportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentItem {

    private String text;
    private List<ContentSubItem> subItems;
}
