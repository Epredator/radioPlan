package com.etroya.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Adam on 2015-05-31.
 */
@XmlRootElement
public class Message {
    private long id;
    private String message;
    private Date created;
    private String author;

    public Message(){

    }

    public Message(int i, String s, String author) {
        this.id =i;
        this.message = s;
        this.author = author;
        this.created = new Date();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
