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
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@QueryParam("year") int year,
                                     @QueryParam("start") int start,
                                     @QueryParam("size") int size){
        if (year > 0)
            return messageService.getAllMessagesForYear(year);
        if (start>=0 && size>=0)
            return messageService.getAllMessagesPaginated(start, size);
        return messageService.getAllMessages();
    }

    @POST
    public Message addMessage(Message message){
        messageService.addMessage(message);
        return message;
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id){
        messageService.removeMessage(id);
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long id){
        return messageService.getMessage(id);
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long id, Message message){
        message.setId(id);
        messageService.updateMessage(message);
        return message;
    }
}
