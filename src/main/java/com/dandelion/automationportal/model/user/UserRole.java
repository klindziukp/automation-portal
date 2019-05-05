package com.dandelion.automationportal.model.user;

import java.util.Arrays;
import java.util.List;

public enum UserRole {

    GUEST, MENTOR, MENTEE, RM, ADMIN;

    public static List<UserRole> getAllRoles(){
        return Arrays.asList(UserRole.values());
    }
}
