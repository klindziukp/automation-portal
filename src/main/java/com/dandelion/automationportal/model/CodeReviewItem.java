package com.dandelion.automationportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "codereview")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeReviewItem implements Comparable<CodeReviewItem> {

    @Id
    private String id;
    private String key;
    private String value;
    private String topicKey;
    private String startLine;

    @Override
    public int compareTo(CodeReviewItem codeReviewItem) {
        return this.key.compareTo(codeReviewItem.getKey());
    }
}
