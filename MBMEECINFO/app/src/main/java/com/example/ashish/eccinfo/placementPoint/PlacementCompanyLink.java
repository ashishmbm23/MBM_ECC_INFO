package com.example.ashish.eccinfo.placementPoint;

import java.io.Serializable;

/**
 * Created by Ashish on 8/21/2017.
 */

public class PlacementCompanyLink implements Serializable{
    private String linktext;
    private String linkDesc;

    public PlacementCompanyLink(String linktext, String linkDesc) {
        this.linktext = linktext;
        this.linkDesc = linkDesc;
    }

    public PlacementCompanyLink() {
    }

    public String getLinktext() {
        return linktext;
    }

    public void setLinktext(String linktext) {
        this.linktext = linktext;
    }

    public String getLinkDesc() {
        return linkDesc;
    }

    public void setLinkDesc(String linkDesc) {
        this.linkDesc = linkDesc;
    }

    @Override
    public String toString() {
        return this.getLinktext();
    }
}
