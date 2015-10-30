package com.etroya.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * Created by Adam on 2015-06-23.
 */
@Embeddable
public class Address {
    @Column(name="CITY_STREET")
    private String street;
    @Column(name="CITY_NAME")
    private String city;
    @Column(name="CITY_COUNTRY")
    private String country;
    @Column(name="CITY_CODE")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
