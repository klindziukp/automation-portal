package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.CodeReviewRepository;
import com.dandelion.automationportal.layer.repository.mongo.CodeReviewMongoRepository;
import com.dandelion.automationportal.layer.service.CodeReviewService;
import com.dandelion.automationportal.model.CodeReviewItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeReviewServiceImpl implements CodeReviewService {

    private CodeReviewRepository codeReviewRepository;

    @Autowired
    public CodeReviewServiceImpl(CodeReviewMongoRepository codeReviewMongoRepository) {
        this.codeReviewRepository = codeReviewMongoRepository;
    }

    @Override
    public List<CodeReviewItem> getCodeReviewItemsByTopicKey(String topicKey) {
        return codeReviewRepository.findAllByTopicKey(topicKey);
    }

    @Override
    public List<CodeReviewItem> getAllCodeReviewItems() {
        return codeReviewRepository.findAll();
    }
}
