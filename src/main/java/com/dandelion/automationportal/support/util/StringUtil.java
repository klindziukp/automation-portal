package com.dandelion.automationportal.support.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {

    private StringUtil() {
    }

    public static String getChapterNameFromKey(String chapterName) {
        return StringUtils.capitalize(chapterName);
    }

    public static String[] splitByUpperCase(String text) {
        return text.split("(?=\\p{Upper})");
    }

    public static String getFirstMatch(String regexp, String text) {
        Matcher m = Pattern.compile(regexp).matcher(text);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

}
