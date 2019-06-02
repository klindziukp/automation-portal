package com.dandelion.automationportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "topics")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Topic {

	@Id
	private String id;
	private String key;
	private String name;
	private String parent;
	private String description;
}
