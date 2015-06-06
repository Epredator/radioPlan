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
    @Path("/{profileId}")
    public void deleteProfile(@PathParam("profileId") long id){
        profileService.removeProfile(id);
    }

    @GET
    @Path("/{profileId}")
    public Profile getProfile(@PathParam("profileId")long id){
        return profileService.getProfile(id);
    }

    @PUT
    @Path("/{profileId}")
    public Profile updateProfile(@PathParam("profileId") long id, Profile profile){
        profile.setId(id);
        profileService.updateProfile(profile);
        return profile;
    }
}

