package com.etroya.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Adam on 2015-06-03.
 */
@Entity
@XmlRootElement
public class Profile {
    @Id @GeneratedValue
    private long id;
    private String profileName;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    private String email;
    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride (name="street", column = @Column(name="HOME_STREET_NAME")),
//            @AttributeOverride (name="city", column = @Column(name="CITY_STREET_NAME")),
//            @AttributeOverride (name="country", column = @Column(name="COUNTRY_STREET_NAME")),
//            @AttributeOverride (name="code", column = @Column(name="CODE_STREET_NAME"))
//    })
    private Address homeAddress;
    @Embedded
    private Address officeAddress;

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    @Lob
    private String description;

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public Profile(){
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
