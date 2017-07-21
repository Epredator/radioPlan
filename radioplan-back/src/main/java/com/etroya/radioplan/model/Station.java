package com.etroya.radioplan.model;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by eperedator on 22.07.17.
 */
@Entity
public class Station {

    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 200)
    private String title;
    @Column(length = 1000)
    private String description;
    @Column(name ='start_station_date')
    @Temporal(TemporalType.DATE)
    private Date startStationDate;
    @Column(name ='image_url')
    private String imageUrl;
    private Language language;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartStationDate() {
        return startStationDate;
    }

    public void setStartStationDate(Date startStationDate) {
        this.startStationDate = startStationDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startStationDate=" + startStationDate +
                ", imageUrl='" + imageUrl + '\'' +
                ", language=" + language +
                '}';
    }
}
