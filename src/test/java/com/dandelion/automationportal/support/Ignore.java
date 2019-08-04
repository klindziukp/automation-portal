package com.dandelion.automationportal.support;

public final class Ignore {

    private Ignore() {
    }

    public static String[] getUpdatableEntityFields() {
        return new String[] { "id", "createdAt", "updatedAt", "deletedAt", "createdBy", "updatedBy", "deletedBy" };
    }
}
