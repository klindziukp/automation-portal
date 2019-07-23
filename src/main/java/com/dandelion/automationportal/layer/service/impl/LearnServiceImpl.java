package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.ChaptersRepository;
import com.dandelion.automationportal.layer.repository.ChaptersRepository.ChapterSelfCheckProjection;
import com.dandelion.automationportal.layer.service.LearnJpaService;
import com.dandelion.automationportal.model.chapter.SelfCheckQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnServiceImpl implements LearnJpaService {

    private ChaptersRepository chaptersJpaRepository;

    @Autowired
    public LearnServiceImpl(ChaptersRepository chaptersJpaRepository) {
        this.chaptersJpaRepository = chaptersJpaRepository;
    }

    @Override
    public List<ChapterSelfCheckProjection> findAllSelfCheckQuestionsByChapterName(String chapterName) {
        return chaptersJpaRepository.findAllSelfCheckQuestionsByChapterName(chapterName);
    }
}
