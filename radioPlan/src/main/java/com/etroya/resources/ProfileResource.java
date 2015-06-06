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
public class ProfileResource {
    ProfileService profileService = new ProfileService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getProfiles(){
        return profileService.getAllProfiles();
    }

    @GET
    @Path("/{profileId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile getProfile(@PathParam("profileId")long id){
        return profileService.getProfile(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile addProfile(Profile profile){
        profileService.addProfile(profile);
        return profile;
    }
}

