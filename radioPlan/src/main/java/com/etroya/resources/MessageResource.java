package com.etroya.resources;

import com.etroya.model.Message;
import com.etroya.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }


    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String postMessage(String message){
        return "Twoja wiadomość: "+ message;

    }
}
