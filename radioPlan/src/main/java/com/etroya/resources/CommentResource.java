package com.etroya.resources;

import com.etroya.service.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Adam on 2015-06-11.
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
    private CommentService commentService = new CommentService();

    @GET
    public String getComment(){
        return "test";
    }

    @GET
    @Path("/{commentId}")
    public String getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
        return "Your comment have ID: " + commentId + " for message with ID: " + messageId;
    }
}
