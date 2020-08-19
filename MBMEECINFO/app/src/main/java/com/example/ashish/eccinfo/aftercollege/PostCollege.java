package com.example.ashish.eccinfo.aftercollege;

import com.example.ashish.eccinfo.academic.DataAcedemicDownloadModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 7/23/2017.
 */

public class PostCollege implements Serializable{

    private String postCollegeId;
    private String postCollegeName;
    private String document;
    private String procedure;
    private List<DataAcedemicDownloadModel> downloadLinks = new ArrayList<>();

    public List<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<String> menuList) {
        this.menuList = menuList;
    }

    private List<String> menuList = new ArrayList<>();
    {
        menuList.add("Document");
        menuList.add("Procedure");
        menuList.add("Download Link");
    }
    public String getPostCollegeId() {
        return postCollegeId;
    }

    public void setPostCollegeId(String postCollegeId) {
        this.postCollegeId = postCollegeId;
    }

    public String getPostCollegeName() {
        return postCollegeName;
    }

    public void setPostCollegeName(String postCollegeName) {
        this.postCollegeName = postCollegeName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public List<DataAcedemicDownloadModel> getDownloadLinks() {
        return downloadLinks;
    }

    public void setDownloadLinks(List<DataAcedemicDownloadModel> downloadLinks) {
        this.downloadLinks = downloadLinks;
    }

    @Override
    public String toString() {
        return this.getPostCollegeName();
    }
}
