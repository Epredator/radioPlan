package com.etroya.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.NamedNativeQuery;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Adam on 2015-06-03.
 */

@XmlRootElement
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@NamedQuery(name="Profile.byId", query = "from Profile where id = ?")
//@NamedNativeQuery(name="ProfileDetails.byName", query = "select * from profile where profilename = ?", resultClass = Profile.class);
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)

public class Profile {
    private String profileName;
    @Id @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    @ElementCollection(fetch = FetchType.EAGER)
//    @JoinTable(name = "USER_ADDRESS")
    @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    @CollectionId(columns = {@Column(name = "ADDRESS_ID")}, generator = "hilo-gen", type = @Type(type = "long"))
    private Collection<Address> listOfAddresses = new ArrayList<>();
    @Lob
    private String description;
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    private String email;
    @ManyToMany(mappedBy = "profiles")
    private Collection<Station> stations = new ArrayList<>();
    @ManyToMany(mappedBy = "profiles")
    private Collection<Program> programs = new ArrayList<>();

    public Profile(){
    }

    public Collection<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Collection<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

    public Profile(long id, String profileName, String firstName, String lastName){
        this.id = id;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Collection<Station> getStations() {
        return stations;
    }

    public void setStations(Collection<Station> stations) {
        this.stations = stations;
    }

    public Collection<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(Collection<Program> programs) {
        this.programs = programs;
    }

    public Date getJoindedDate() {
        return joinDate;
    }

    public void setJoindedDate(Date joindedDate) {
        this.joinDate = joindedDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}