package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.model.VocabularyItem;

import java.util.List;

public interface VocabularyJpaService {

    List<VocabularyItem> getAllItemsOrderByKeyAsc();
}
