package com.dandelion.automationportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "chapters")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Chapter {

	@Id
	private String id;
	private String key;
	private String name;
	private String parent;
	private String description;
	private String generalInfo;
	private List<ContentItem> questions;
	private List<ContentItem> notes;
	private List<ContentItem> tasks;
	private List<ContentItem> links;
}
