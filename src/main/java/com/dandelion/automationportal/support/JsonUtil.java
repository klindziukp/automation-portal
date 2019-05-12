package com.dandelion.automationportal.support;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public final class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        try {
            return mapper.readValue(json, classOfT);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static <T> T fromJson(File file, Class<T> classOfT) {
        try {

            return mapper.readValue(file, classOfT);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static <T> List<T> fromJsonToList(File file, Class<T> classOfT) {
        try {
            JavaType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, classOfT);
            return mapper.readValue(file, collectionType);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}