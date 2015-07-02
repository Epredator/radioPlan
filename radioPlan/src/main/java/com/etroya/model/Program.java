package com.etroya.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 * Created by Adam on 2015-05-31.
 */
@Entity
@XmlRootElement
public class Program {
    @Id @GeneratedValue
    private long id;
    private String name;
    private Date startDate;
    private Date endDate;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Comment> comments = new ArrayList<>();
    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    private Station station = new Station();
    @ManyToMany
    private Collection<Profile> profiles = new ArrayList<>();

    public Program(){

    }

    public Collection<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Collection<Profile> profiles) {
        this.profiles = profiles;
    }

    public Program(int i, String nameOfProgram, Date startDate, Date endDate, String stationName) {
        this.id = i;
        this.name = nameOfProgram;
        this.startDate = startDate;
        this.endDate = endDate;
//        this.station = stationName;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
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
