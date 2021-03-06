package com.dandelion.automationportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "questions")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SelfCheckQuestion {

	@Id
	private String id;
	private String chapterKey;
	private String question;
	private String answer;
}
