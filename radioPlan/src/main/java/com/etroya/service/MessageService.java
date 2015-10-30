package com.etroya.service;

import com.etroya.database.DatabaseClass;
import com.etroya.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 2015-05-31.
 */
public class MessageService {
    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService(){
        messages.put(1L, new Message(1, "First message", "Epredator"));
        messages.put(2L, new Message(2, "Secong message", "Saddam"));
    }


    public List<Message> getAllMessages(){
        return new ArrayList<Message> (messages.values());
    }

    public List<Message> getAllMessagesForYear(int year){
        List<Message> messagesForYear = new ArrayList();
            Calendar cal = Calendar.getInstance();
        for(Message message : messages.values()){
            cal.setTime(message.getCreated());
            if(cal.get(Calendar.YEAR) == year)
                messagesForYear.add(message);
        }
        return messagesForYear;
    }

    public List<Message> getAllMessagesPaginated(int start, int size){
        List<Message> list = new ArrayList<Message>(messages.values());
        return list.subList(start, start+size);
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