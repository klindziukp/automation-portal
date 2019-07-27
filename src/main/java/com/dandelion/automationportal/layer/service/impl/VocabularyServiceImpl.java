package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.impl.VocabularyJpaRepository;
import com.dandelion.automationportal.layer.service.VocabularyService;
import com.dandelion.automationportal.model.VocabularyItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocabularyServiceImpl implements VocabularyService {

    private VocabularyJpaRepository vocabularyJpaRepository;

    @Autowired
    public VocabularyServiceImpl(VocabularyJpaRepository vocabularyJpaRepository) {
        this.vocabularyJpaRepository = vocabularyJpaRepository;
    }

    @Override
    public List<VocabularyItem> getAllItemsOrderByKeyAsc() {
        return vocabularyJpaRepository.findAllByOrderByKeyAsc();
    }
}
