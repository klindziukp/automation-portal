package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.AutomationRepository;
import com.dandelion.automationportal.layer.service.LearnJpaService;
import com.dandelion.automationportal.model.chapter.Chapter;
import com.dandelion.automationportal.model.chapter.SelfCheckQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnServiceImpl implements LearnJpaService {

    private AutomationRepository automationRepository;

    @Autowired
    public LearnServiceImpl(AutomationRepository automationRepository) {
        this.automationRepository = automationRepository;
    }

    @Override
    public String getChapterNameFromKey(String chapterKey) {
        return null;
    }

    @Override
    public Chapter findFirstChapterById(String chapterName) {
        return null;
    }

    @Override
    public List<SelfCheckQuestion> findAllSelfCheckQuestionsByChapterName(String chapterName) {
        return automationRepository.findAll().get(0).getChapters().get(0).getSelfCheckQuestions();
    }
}
