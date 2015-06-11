package com.etroya.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Adam on 2015-06-11.
 */
@Path("/")
public class CommentResource {

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
