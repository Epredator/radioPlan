package com.etroya.resources;

import com.etroya.exception.DataNotFoundException;
import com.etroya.model.Message;
import com.etroya.resources.beans.MessageFilterBean;
import com.etroya.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;
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
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean){
        if (filterBean.getYear() > 0)
            return messageService.getAllMessagesForYear(filterBean.getYear());
        if (filterBean.getStart()>=0 && filterBean.getSize()>=0)
            return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
        return messageService.getAllMessages();
    }

    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException {
        Message newMessage = messageService.addMessage(message);;
        String newId = String.valueOf(newMessage.getId());
        URI url = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return  Response.status(Response.Status.CREATED)
                .location(url)
                .entity(newMessage)
                .build();
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id){
        messageService.removeMessage(id);
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long id){
        Message message = messageService.getMessage(id);
        if (message == null){
            throw new DataNotFoundException("Message with id: " + id + " doesn't found.");
        }
        return messageService.getMessage(id);
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long id, Message message){
        message.setId(id);
        messageService.updateMessage(message);
        return message;
    }

    @Path("/{messageId}/comments")
    public CommentResource getCommentResource(){
        return new CommentResource();
    }
}
