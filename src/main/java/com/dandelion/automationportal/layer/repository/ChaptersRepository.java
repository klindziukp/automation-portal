package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.model.chapter.Chapter;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChaptersRepository {

    @Query(value = "SELECT chapter_name AS chapterName, question, answer FROM self_check_question s WHERE s.chapter_name = ?1", nativeQuery = true)
    List<ChapterSelfCheckProjection> findAllSelfCheckQuestionsByChapterName(String chapterName);

    Chapter findChapterByName(String name);

    interface ChapterSelfCheckProjection {
        String getChapterName();
        String getQuestion();
        String getAnswer();
    }
}
