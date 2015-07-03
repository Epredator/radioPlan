package com.etroya.model;

import javax.persistence.Entity;

/**
 * Created by Adam on 2015-07-03.
 * reklama produktu
 */
@Entity
public class Advertisement extends Program  {
    String productName;
    String producer;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
