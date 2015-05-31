package com.etroya.model;

import java.util.Date;

/**
 * Created by Adam on 2015-05-31.
 */
public class Program {
    private long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private Date station;

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

    public Date getStation() {
        return station;
    }

    public void setStation(Date station) {
        this.station = station;
    }

}
