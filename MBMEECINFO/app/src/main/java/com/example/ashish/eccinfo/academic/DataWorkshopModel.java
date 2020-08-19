package com.example.ashish.eccinfo.academic;

import java.io.Serializable;

/**
 * Created by Ashish on 8/20/2017.
 */

public class DataWorkshopModel implements Serializable {

    private String WorkshopTitle;
    private String WorkshopDesc;

    public DataWorkshopModel() {
    }

    public DataWorkshopModel(String workshopTitle, String workshopDesc) {
        WorkshopTitle = workshopTitle;
        WorkshopDesc = workshopDesc;
    }

    public String getWorkshopTitle() {
        return WorkshopTitle;
    }

    public void setWorkshopTitle(String workshopTitle) {
        WorkshopTitle = workshopTitle;
    }

    public String getWorkshopDesc() {
        return WorkshopDesc;
    }

    public void setWorkshopDesc(String workshopDesc) {
        WorkshopDesc = workshopDesc;
    }

    @Override
    public String toString() {
        return this.getWorkshopTitle();
    }
}
