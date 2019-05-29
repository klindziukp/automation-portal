package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.model.CodeReviewItem;

import java.util.List;

public interface CodeReviewService {

    List<CodeReviewItem> getAllCodeReviewItems();
    List<CodeReviewItem> getCodeReviewItemsByTopicKey(String topicKey);
}
