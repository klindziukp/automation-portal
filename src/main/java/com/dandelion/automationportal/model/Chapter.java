package com.dandelion.automationportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
	private String description;
	private String generalInfo;
	private int approxTimeHours;
	private List<ContentItem> questions;
	private List<ContentItem> selfStudyQuestions;
	private List<ContentItem> notes;
	private List<ContentItem> acceptanceCriteria;
	private List<ContentItem> tasks;
	private List<ContentItem> knowledgeTransfer;
	private List<ContentItem> links;
}
