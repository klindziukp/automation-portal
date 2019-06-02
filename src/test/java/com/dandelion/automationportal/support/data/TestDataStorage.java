package com.dandelion.automationportal.support.data;

import com.dandelion.automationportal.model.Chapter;
import com.dandelion.automationportal.model.CodeReviewItem;
import com.dandelion.automationportal.model.Program;
import com.dandelion.automationportal.model.SelfCheckQuestion;
import com.dandelion.automationportal.model.Topic;
import com.dandelion.automationportal.model.VocabularyItem;

public final class TestDataStorage {

    private static final String TEST_CHAPTER_KEY = "testChapterKey";
    private static final String TEST_CODE_ITEM_KEY = "testCodeReviewKey";
    private static final String TEST_TOPIC_KEY = "testTopicKey";

    private TestDataStorage() {
    }

    public static Chapter getTestChapter() {
        Chapter testChapter = new Chapter();
        testChapter.setKey(TEST_CHAPTER_KEY);
        return testChapter;
    }

    public static CodeReviewItem getTestCodeReviewItem() {
        CodeReviewItem testCodeReviewItem = new CodeReviewItem();
        testCodeReviewItem.setKey(TEST_CODE_ITEM_KEY);
        return testCodeReviewItem;
    }

    public static Topic getTestTopic() {
        Topic testTopic = new Topic();
        testTopic.setKey(TEST_TOPIC_KEY);
        return testTopic;
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
