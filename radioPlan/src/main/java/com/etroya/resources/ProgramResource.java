package com.etroya.resources;

import com.etroya.model.Program;
import com.etroya.service.ProgramService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Adam on 2015-05-30.
 */

@Path("/programs")
public class ProgramResource {
    ProgramService programService = new ProgramService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Program> getPrograms(){
        return programService.getAllPrograms();
    }

    @GET
    @Path("/{programId}")
    @Produces(MediaType.APPLICATION_XML)
    public Program getProgram(@PathParam("programId") long id){
        return programService.getProgram(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_XML)
    public String postProgram(String programName){
        return "Nazwa programu: "+programName;
    }

}
