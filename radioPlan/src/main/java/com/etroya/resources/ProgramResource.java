package com.etroya.resources;

import com.etroya.model.Program;
import com.etroya.service.ProgramService;

import javax.print.attribute.standard.Media;
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
    @Produces(MediaType.APPLICATION_JSON)
    public List<Program> getPrograms(){
        return programService.getAllPrograms();
    }

    @GET
    @Path("/{programId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Program getProgram(@PathParam("programId") long id){
        return programService.getProgram(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Program addProgram(Program program){
        programService.addProgram(program);
        return program;
    }

}
