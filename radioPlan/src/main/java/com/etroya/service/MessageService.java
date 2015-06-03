package com.etroya.service;

import com.etroya.database.DatabaseClass;
import com.etroya.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 2015-05-31.
 */
public class MessageService {

    public MessageService(){
        Message m1 = new Message(1, "First message", "Epredator");
        Message m2 = new Message(2, "Secong message", "Saddam");
    }
    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public List<Message> getAllMessages(){
        return (ArrayList<Message>) messages.values();
    }

    public Message getMessage(long id){
        return messages.get(id);
    }

    public Message addMessage(Message message){
        message.setId(messages.size()+1);
        messages.put(message.getId(), message);
        return message;
        }

    public Message updateMessage(Message message){
        if(message.getId() <= 0){
            return null;
        }else{
            messages.put(message.getId(), message);
            return message;
        }
    }

    public Message removeMessage(long id){
        return messages.remove(id);

    }

}
