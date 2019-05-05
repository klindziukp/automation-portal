package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.model.Chapter;
import com.dandelion.automationportal.model.SelfCheckQuestion;

import java.util.List;

public interface LearnService {

    String getChapterNameFromKey(String chapterKey);
    Chapter findFirstChapterByKey(String chapterKey);
    List<SelfCheckQuestion> findAllByChapterKey(String chapterKey);
}
