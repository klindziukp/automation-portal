package com.dandelion.automationportal.support.data;

import com.dandelion.automationportal.model.Chapter;
import com.dandelion.automationportal.model.Program;
import com.dandelion.automationportal.model.SelfCheckQuestion;

import java.util.List;
import java.util.stream.Collectors;

public final class TestDataStorage {

	private static final String TEST_CHAPTER_KEY = "testChapterKey";
	private static final String TEST_QUESTION = "Test Question";
	private static final String TEST_ANSWER = "Test answer";
	private static final String TEST_USER = "Test user";

	private TestDataStorage() {
	}

	public static Chapter getTestChapter() {
		Chapter testChapter = new Chapter();
		testChapter.setKey(TEST_CHAPTER_KEY);
		return testChapter;
	}

	public static List<SelfCheckQuestion> getSelfCheckQuestions(String chapterKey) {
		return JsonTestDataStorage.getSelfCheckQuestions().stream()
				.filter(selfCheckQuestion -> selfCheckQuestion.getChapterKey().equals(chapterKey))
				.collect(Collectors.toList());
	}

	public static SelfCheckQuestion getTestSelfCheckQuestion() {
		SelfCheckQuestion selfCheckQuestion = new SelfCheckQuestion();
		selfCheckQuestion.setQuestion(TEST_QUESTION);
		selfCheckQuestion.setAnswer(TEST_ANSWER);
		return selfCheckQuestion;
	}

	public static Program getTestProgram() {
		Program testProgram = new Program();
		testProgram.setName("TestProgram");
		return testProgram;
	}

}
