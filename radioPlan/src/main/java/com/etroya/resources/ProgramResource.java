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
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProgramResource {
    ProgramService programService = new ProgramService();

    @GET
    public List<Program> getPrograms(@QueryParam("start") int start,
                                     @QueryParam("size") int size){
        if(start >= 0 && size >= 0){
            return programService.getAllProgramsPaginated(start, size);
        }
        return programService.getAllPrograms();
    }

    @POST
    public Program addProgram(Program program){
        programService.addProgram(program);
        return program;
    }

    @DELETE
    @Path(("/{programId}"))
    public Program deleteProgram(@PathParam("programId") long id){
        return programService.removeProgram(id);
    }

    @GET
    @Path("/{programId}")
    public Program getProgram(@PathParam("programId") long id){
        return programService.getProgram(id);
    }

    @PUT
    @Path("/{programId}")
    public Program updateProgram(@PathParam("programId") long id, Program program){
        program.setId(id);
        programService.updateProgram(program);
        return program;
    }

    @Path("/{programId}/comments")
    public CommentResource getCommentResource(){
        return new CommentResource();
    }

}
