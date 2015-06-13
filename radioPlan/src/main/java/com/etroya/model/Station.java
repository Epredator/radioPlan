package com.etroya.model;

import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adam on 2015-06-13.
 */
public class Station {
    private long id;

    private String name;
    private Date startDate;
    private Date endDate;
    private Map<Long, Program> programs = new HashMap<>();
    private Map<Long, Comment> comments = new HashMap<>();

    public Station(){

    }

    public Station(long id, String nameOfStation, Date startDate, Date endDate){
        this.id = id;
        this.name = nameOfStation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @XmlTransient
    public Map<Long, Program> getPrograms(){
        return programs;
    }

    public void setPrograms(Map<Long, Program> programs){
        this.programs = programs;
    }

    public Map<Long, Comment> getComments(){
        return comments;
    }

    public void setComments(Map<Long, Comment> comments){
        this.comments = comments;
    }
}
