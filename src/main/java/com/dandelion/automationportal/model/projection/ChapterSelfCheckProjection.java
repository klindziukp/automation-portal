package com.dandelion.automationportal.model.projection;

public interface ChapterSelfCheckProjection {

    String getChapterName();
    String getQuestion();
    String getAnswer();
    void setChapterName(String chapterName);
    void setQuestion(String question);
    void setAnswer(String answer);
}
