package com.dandelion.automationportal.support.data;

import com.dandelion.automationportal.model.Chapter;
import com.dandelion.automationportal.model.HowToCategory;
import com.dandelion.automationportal.model.Mentorship;
import com.dandelion.automationportal.model.Program;
import com.dandelion.automationportal.model.SelfCheckQuestion;
import com.dandelion.automationportal.model.user.User;
import com.dandelion.automationportal.support.JsonUtil;

import java.io.File;
import java.util.List;

public final class JsonTestDataStorage {

	public static final String JSON_FOLDER_PATH = String
			.join(File.separator, System.getProperty("user.dir"), "src", "test", "resources", "");

	private JsonTestDataStorage() {
	}

	public static List<Chapter> getChapters() {
		return getListOfItems("chapters.json", Chapter.class);
	}

	public static List<HowToCategory> getHowToCategories() {
		return getListOfItems("howTo.json", HowToCategory.class);
	}

	public static List<User> getUsers() {
		return getListOfItems("users.json", User.class);
	}

	public static List<Mentorship> getMentorships() {
		return getListOfItems("mentorships.json", Mentorship.class);
	}

	public static List<Program> getPrograms() {
		return getListOfItems("program.json", Program.class);
	}

	public static List<SelfCheckQuestion> getSelfCheckQuestions() {
		return getListOfItems("questions.json", SelfCheckQuestion.class);
	}

	private static <T> List<T> getListOfItems(String jsonCollectionName, Class<T> classOfT) {
		return JsonUtil.fromJsonToList(new File(JSON_FOLDER_PATH + jsonCollectionName), classOfT);
	}
}
