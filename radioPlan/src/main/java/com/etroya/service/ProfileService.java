package com.etroya.service;

import com.etroya.database.DatabaseClass;
import com.etroya.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 2015-06-05.
 */
public class ProfileService {
    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService(){
        profiles.put("Epredator", new Profile(1, "Epredator", "Adam", "Więcławski"));
        profiles.put("Saddam", new Profile(2, "Saddam", "Bożysław", "Zabłoński"));
    }

    public List<Profile> getAllProfiles(){
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profileName){
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile){
        profile.setId(profiles.size()+1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile){
        if(profile.getProfileName().isEmpty()){
            return null;
        }else{
            profiles.put(profile.getProfileName(), profile);
            return profile;
        }
    }

    public Profile removeProfile(String profileName){
        return profiles.remove(profileName);
    }
}
