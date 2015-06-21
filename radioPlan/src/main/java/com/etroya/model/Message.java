package com.etroya.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

/**
 * Created by Adam on 2015-05-31.
 */
@Entity
@XmlRootElement
public class Message {
    @Id
    private long id;
    private String message;
    private Date created;
    private String author;
    private List<Link> links = new ArrayList<>();
    private Map<Long, Comment> comments = new HashMap<>();

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

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

    @XmlTransient
    public Map<Long, Comment> getComments(){
        return comments;
    }

    public void setComments(Map<Long, Comment> comments){
        this.comments = comments;
    }

    public void addLink(String url, String rel){
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }
}
