package com.etroya.model;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adam on 2015-05-31.
 */
@Embeddable
@XmlRootElement
public class Program {
    @Id
    private long id;
    private String name;
    private Date startDate;
    private Date endDate;
//    private String station;
//    @ElementCollection
//    private Map<Long, Comment> comments = new HashMap<>();

    public Program(){

    }

    public Program(int i, String nameOfProgram, Date startDate, Date endDate, String stationName) {
        this.id = i;
        this.name = nameOfProgram;
        this.startDate = startDate;
        this.endDate = endDate;
//        this.station = stationName;
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

//    public String getStation() {
//        return station;
//    }
//
//    public void setStation(String station) {
//        this.station = station;
//    }

//    @XmlTransient
//    public Map<Long, Comment> getComments(){
//        return comments;
//    }
//
//    public void setComments(Map<Long, Comment> comments){
//        this.comments = comments;
//    }

}
