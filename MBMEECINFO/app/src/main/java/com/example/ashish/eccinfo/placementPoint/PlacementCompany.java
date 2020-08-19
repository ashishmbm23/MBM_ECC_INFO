package com.example.ashish.eccinfo.placementPoint;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 8/21/2017.
 */

public class PlacementCompany implements Serializable {

    private String companyId;
    private String companyName;
    private String companyDocument;
    private String companyEligibilityCriteria;
    private List<PlacementCompanyPattern> companyPatternList =new ArrayList<>();
    private List<PlacementCompanyLink> companyLinkList = new ArrayList<>();
    private List<String> listDetails = new ArrayList<>();
    private String companyDetail;

    public PlacementCompany(String companyId, String companyName, String companyDocument, String companyEligibilityCriteria, List<PlacementCompanyPattern> companyPatternList, List<PlacementCompanyLink> companyLinkList, List<String> listDetails, String companyDetail) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyDocument = companyDocument;
        this.companyEligibilityCriteria = companyEligibilityCriteria;
        this.companyPatternList = companyPatternList;
        this.companyLinkList = companyLinkList;
        this.listDetails = listDetails;
        this.companyDetail = companyDetail;
    }

    public String getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(String companyDetail) {
        this.companyDetail = companyDetail;
    }

    public String getCompanyEligibilityCriteria() {
        return companyEligibilityCriteria;
    }

    public void setCompanyEligibilityCriteria(String companyEligibilityCriteria) {
        this.companyEligibilityCriteria = companyEligibilityCriteria;
    }

    {
        listDetails.add("Informal details of placement");
        listDetails.add("Recruitment / Selection Process");
        listDetails.add("Important Documents");
        listDetails.add("Eligibility Criteria");
        listDetails.add("Useful External links");

    }

    public List<String> getListDetails() {
        return listDetails;
    }

    public void setListDetails(List<String> listDetails) {
        this.listDetails = listDetails;
    }

    public PlacementCompany() {
    }

    public PlacementCompany(String companyId, String companyName, String companyDocument, List<PlacementCompanyPattern> companyPatternList, List<PlacementCompanyLink> companyLinkList) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyDocument = companyDocument;
        this.companyPatternList = companyPatternList;
        this.companyLinkList = companyLinkList;
    }

    public String getCompanyDocument() {
        return companyDocument;
    }

    public void setCompanyDocument(String companyDocument) {
        this.companyDocument = companyDocument;
    }





    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<PlacementCompanyPattern> getCompanyPatternList() {
        return companyPatternList;
    }

    public void setCompanyPatternList(List<PlacementCompanyPattern> companyPatternList) {
        this.companyPatternList = companyPatternList;
    }

    public List<PlacementCompanyLink> getCompanyLinkList() {
        return companyLinkList;
    }

    public void setCompanyLinkList(List<PlacementCompanyLink> companyLinkList) {
        this.companyLinkList = companyLinkList;
    }

    @Override
    public String toString() {
        return this.getCompanyName();
    }
}
