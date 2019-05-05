package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.model.SelfCheckQuestion;
import java.util.List;

public interface QuestionsRepository {

    List<SelfCheckQuestion> findAllByChapterKey(String chapterKey);
    List<SelfCheckQuestion> findAll();
}
