package com.etroya.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Adam on 2015-05-30.
 */

@Path("/messages")
public class MessageResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessages(){
        return "this is new message.";
    }


    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String postMessage(String message){
        return "Twoja wiadomość: "+ message;

    }
}
