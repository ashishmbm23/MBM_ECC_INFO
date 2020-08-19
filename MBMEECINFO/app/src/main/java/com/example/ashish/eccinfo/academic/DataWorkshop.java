package com.example.ashish.eccinfo.academic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 8/20/2017.
 */

public class DataWorkshop implements Serializable {
    private List<DataWorkshopModel> dataWorkshopModelList = new ArrayList<>() ;

    public List<DataWorkshopModel> getDataWorkshopModelList() {
        return dataWorkshopModelList;
    }

    public void setDataWorkshopModelList(List<DataWorkshopModel> dataWorkshopModelList) {
        this.dataWorkshopModelList = dataWorkshopModelList;
    }
}
