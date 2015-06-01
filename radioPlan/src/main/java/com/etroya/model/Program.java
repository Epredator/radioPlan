package com.etroya.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Adam on 2015-05-31.
 */
@XmlRootElement
public class Program {

    public Program(){

    }

    private long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private String station;

    public Program(int i, String nameOfProgram, Date startDate, Date endDate, String stationName) {
        this.id = i;
        this.name = nameOfProgram;
        this.startDate = startDate;
        this.endDate = endDate;
        this.station = stationName;
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

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

}
