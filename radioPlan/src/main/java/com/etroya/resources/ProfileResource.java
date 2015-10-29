package com.etroya.resources;

import com.etroya.model.Profile;
import com.etroya.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Adam on 2015-06-05.
 */
@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
    ProfileService profileService = new ProfileService();

    @GET
    public List<Profile> getProfiles(){
        return profileService.getAllProfiles();
    }

    @POST
    public Profile addProfile(Profile profile){
        profileService.addProfile(profile);
        return profile;
    }

    @DELETE
    @Path("/{profileName}")
    public void deleteProfile(@PathParam("profileName") String profileName){
        profileService.removeProfile(profileName);
    }

    @GET
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName")String profileName){
        return profileService.getProfile(profileName);
    }

    @PUT
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
        profile.setProfileName(profileName);
        profileService.updateProfile(profile);
        return profile;
    }
}

