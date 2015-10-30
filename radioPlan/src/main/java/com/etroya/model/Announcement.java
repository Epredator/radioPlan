package com.etroya.model;

import javax.persistence.*;

/**
 * Created by Adam on 2015-07-03.
 * zapowiedz audycji radiowych.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("Announ")
public class Announcement extends Program {
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
