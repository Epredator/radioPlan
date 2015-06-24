package com.etroya.model;

import javax.persistence.Embeddable;

/**
 * Created by Adam on 2015-06-17.
 */
@Embeddable
public class Link {
    private String link;
    private String rel;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }
}
