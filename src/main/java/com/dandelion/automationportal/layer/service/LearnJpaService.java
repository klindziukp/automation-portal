package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.model.chapter.Chapter;
import com.dandelion.automationportal.model.chapter.SelfCheckQuestion;

import java.util.List;

public interface LearnJpaService {

    String getChapterNameFromKey(String chapterKey);
    Chapter findFirstChapterById(String chapterName);
    List<SelfCheckQuestion> findAllSelfCheckQuestionsByChapterName(String chapterName);
}
