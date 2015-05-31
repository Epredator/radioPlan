package com.etroya.service;

import com.etroya.model.Message;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 2015-05-31.
 */
public class MessageService {

    public List<Message> getAllMessages(){
        Message m1 = new Message(1, "First message", "Epredator");
        Message m2 = new Message(2, "Secong message", "Saddam");
        ArrayList<Message> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        return  list;
    }
}
