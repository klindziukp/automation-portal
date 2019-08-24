package com.dandelion.automationportal.support;

import org.apache.commons.lang3.ArrayUtils;

public final class Ignore {

    private Ignore() {
    }

    public static String[] getUpdatableEntityFields() {
        return new String[] { "id", "createdAt", "updatedAt", "deletedAt", "createdBy", "updatedBy", "deletedBy" };
    }

    public static String[] getAutomationTopicIgnoreFields() {
        return ArrayUtils.addAll(getUpdatableEntityFields(), "automationTopic");
    }
}
