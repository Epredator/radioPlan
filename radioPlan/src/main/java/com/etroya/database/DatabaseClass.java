package com.etroya.database;

import com.etroya.model.Message;
import com.etroya.model.Profile;
import com.etroya.model.Program;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adam on 2015-06-03.
 */
public class DatabaseClass {
    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();
    private static Map<Long, Program> programs = new HashMap<>();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }

    public static Map<Long, Program> getPrograms() {
        return programs;
    }
}
