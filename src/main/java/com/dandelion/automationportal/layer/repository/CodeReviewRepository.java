package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.model.CodeReviewItem;
import java.util.List;

public interface CodeReviewRepository {

    List<CodeReviewItem> findAll();
    List<CodeReviewItem> findAllByTopicKey(String topicKey);
}
