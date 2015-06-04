package com.etroya.resources;

import com.etroya.model.Message;
import com.etroya.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Adam on 2015-05-30.
 */

@Path("/messages")
public class MessageResource {
    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> test(){
        return messageService.getAllMessages();
    }


    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_XML)
    public Message getMessage(@PathParam("messageId") long id){
        return messageService.getMessage(id);
    }


    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String postMessage(String message){
        return "Twoja wiadomość: "+ message;

    }
}
