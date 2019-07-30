package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.model.chapter.Chapter;
import com.dandelion.automationportal.model.projection.ChapterProjection;
import com.dandelion.automationportal.model.projection.ChapterSelfCheckProjection;

import java.util.List;

public interface ChapterService {

    Chapter findChapterByName(String name);
    List<ChapterProjection> findChaptersAllByAutomationName(String name);
    List<ChapterSelfCheckProjection> findAllSelfCheckQuestionsByChapterName(String chapterName);
}
