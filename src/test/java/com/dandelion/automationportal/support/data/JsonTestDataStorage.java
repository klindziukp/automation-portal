package com.dandelion.automationportal.support.data;

import com.dandelion.automationportal.model.Chapter;
import com.dandelion.automationportal.model.CodeReviewItem;
import com.dandelion.automationportal.model.Program;
import com.dandelion.automationportal.model.SelfCheckQuestion;
import com.dandelion.automationportal.model.Topic;
import com.dandelion.automationportal.model.VocabularyItem;
import com.dandelion.automationportal.support.util.JsonUtil;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public final class JsonTestDataStorage {

	public static final String JSON_FOLDER_PATH = String
			.join(File.separator, System.getProperty("user.dir"), "src", "test", "resources", "");

	private JsonTestDataStorage() {
	}

	public static List<String> getChapterKeys() {
		return getListOfItems("automation/chapters.json", Chapter.class)
				.stream()
				.map(Chapter::getKey).collect(
				Collectors.toList());
	}

	public static List<Chapter> getChapters() {
		return getListOfItems("automation/chapters.json", Chapter.class);
	}

    public static List<CodeReviewItem> getCodeReviewItems() {
        return getListOfItems("automation/codereview.json", CodeReviewItem.class);
    }

	public static List<Topic> getTopics() {
		return getListOfItems("automation/topics.json", Topic.class);
	}

	public static List<String> getTopicsKeys(String parentKey){
		return getTopics().stream().filter(topic -> topic.getParent().equals(parentKey)).map(Topic::getKey).collect(Collectors.toList());
	}

	public static List<Program> getPrograms() {
		return getListOfItems("automation/program.json", Program.class);
	}

	public static List<SelfCheckQuestion> getSelfCheckQuestions(String chapterKey) {
		return getListOfItems("automation/questions.json", SelfCheckQuestion.class).stream()
				.filter(selfCheckQuestion -> selfCheckQuestion.getChapterKey().equals(chapterKey))
				.collect(Collectors.toList());
	}

	public static List<VocabularyItem> getVocabularyItems() {
		return getListOfItems("automation/vocabulary.json", VocabularyItem.class);
	}

	private static <T> List<T> getListOfItems(String jsonCollectionName, Class<T> classOfT) {
		return JsonUtil.fromJsonToList(new File(JSON_FOLDER_PATH + jsonCollectionName), classOfT);
	}
}
