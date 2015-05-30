package com.etroya.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Adam on 2015-05-30.
 */

@Path("/programs")
public class ProgramResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getProgram(){
        return "To jest Twój program";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String postProgram(String programName){
        return "Nazwa programu: "+programName;
    }

}
