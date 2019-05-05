package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.VocabularyRepository;
import com.dandelion.automationportal.layer.repository.mongo.VocabularyMongoRepository;
import com.dandelion.automationportal.layer.service.VocabularyService;
import com.dandelion.automationportal.model.VocabularyItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocabularyServiceImpl implements VocabularyService {

    private VocabularyRepository vocabularyRepository;

    @Autowired
    public VocabularyServiceImpl(VocabularyMongoRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }

    @Override
    public List<VocabularyItem> getAllItemsOrderByKeyAsc() {
       return vocabularyRepository.findAllByOrderByKeyAsc();
    }
}
