package com.etroya.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 * Created by Adam on 2015-06-03.
 */

@XmlRootElement
@Entity
public class Profile {
    @Id @GeneratedValue
    private long id;
    private String profileName;
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
