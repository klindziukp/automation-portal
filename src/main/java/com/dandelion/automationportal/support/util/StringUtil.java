package com.dandelion.automationportal.support.util;

import org.testcontainers.shaded.org.apache.commons.lang.WordUtils;

public final class StringUtil {

    private StringUtil() {
    }

    public static String extractTitle(String name) {
        return WordUtils.capitalize(name.replaceAll("-", " "));
    }
}
