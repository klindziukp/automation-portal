package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.layer.repository.ChaptersRepository.ChapterSelfCheckProjection;
import java.util.List;

public interface LearnJpaService {

    List<ChapterSelfCheckProjection> findAllSelfCheckQuestionsByChapterName(String chapterName);
}
