package com.etroya.database;

import com.etroya.model.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adam on 2015-06-03.
 */
public class DatabaseClass {
    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();
    private static Map<Long, Program> programs = new HashMap<>();
    private static Map<Long, Station> stations = new HashMap<>();
    private static Map<Long, Comment> comments = new HashMap<>();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }

    public static Map<Long, Program> getPrograms() {
        return programs;
    }
    public static Map<Long, Comment> getComments() {
        return comments;
    }
    public static Map<Long, Station> getStations() {
        return stations;
    }
}
