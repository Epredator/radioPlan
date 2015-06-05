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
    private Map<Long, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService(){
        profiles.put(1L, new Profile(1, "Epredator", "Adam", "Więcławski"));
        profiles.put(2L, new Profile(2, "Saddam", "Bożysław", "Zabłoński"));
    }

    public List<Profile> getAllProfiles(){
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(long id){
        return profiles.get(id);
    }

    public Profile addProfile(Profile profile){
        profile.setId(profiles.size()+1);
        profiles.put(profile.getId(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile){
        if(profile.getId() <= 0){
            return null;
        }else{
            profiles.put(profile.getId(), profile);
            return profile;
        }
    }

    public Profile removeProfile(long id){
        return profiles.remove(id);
    }
}
