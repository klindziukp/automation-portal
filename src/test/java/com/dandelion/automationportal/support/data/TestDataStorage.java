package com.dandelion.automationportal.support.data;

import com.dandelion.automationportal.model.Chapter;
import com.dandelion.automationportal.model.Program;
import com.dandelion.automationportal.model.SelfCheckQuestion;
import com.dandelion.automationportal.model.VocabularyItem;

public final class TestDataStorage {

    private static final String TEST_CHAPTER_KEY = "testChapterKey";

    private TestDataStorage() {
    }

    public static Chapter getTestChapter() {
        Chapter testChapter = new Chapter();
        testChapter.setKey(TEST_CHAPTER_KEY);
        return testChapter;
    }

    public static Program getTestProgram() {
        Program testProgram = new Program();
        testProgram.setName("TestProgram");
        return testProgram;
    }

    public static VocabularyItem getTestVocabularyItem() {
        VocabularyItem testVocabularyItem = new VocabularyItem();
        testVocabularyItem.setKey("testKey");
        testVocabularyItem.setValue("testValue");
        return testVocabularyItem;
    }
}
