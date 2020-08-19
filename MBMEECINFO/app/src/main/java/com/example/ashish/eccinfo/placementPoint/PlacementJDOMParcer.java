package com.example.ashish.eccinfo.placementPoint;

import android.content.Context;
import android.util.Log;

import com.example.ashish.eccinfo.R;
import com.example.ashish.eccinfo.stringConstant.StringName;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 8/21/2017.
 */

public class PlacementJDOMParcer {
    List<PlacementCompany> placementCompanies = new ArrayList<>();
    PlacementCompany placementCompany;

    public List<PlacementCompany> getPlacementCompanies() {
        return placementCompanies;
    }

    public void setPlacementCompanies(List<PlacementCompany> placementCompanies) {
        this.placementCompanies = placementCompanies;
    }

    public PlacementCompany getPlacementCompany() {
        return placementCompany;
    }

    public void setPlacementCompany(PlacementCompany placementCompany) {
        this.placementCompany = placementCompany;
    }

    public List<PlacementCompany> parseXML(Context paramContext)
    {
        InputStream stream = paramContext.getResources().openRawResource(R.raw.placement_points);
        SAXBuilder saxBuilder = new SAXBuilder();
        List<Element> list = new ArrayList<>();
        List<Element> subList = new ArrayList<>();
        try
        {
            Document document = saxBuilder.build(stream);
            Element rootNode = document.getRootElement();
            list = rootNode.getChildren(StringName.PLACEMENT_COMPANY);
            for (Element node : list) {
                placementCompany = new PlacementCompany();
                placementCompany.setCompanyId(node.getChildText(StringName.PLACEMENT_COMPANY_ID));
                placementCompany.setCompanyName(node.getChildText(StringName.PLACEMENT_COMPANY_NAME));
                placementCompany.setCompanyDetail(node.getChildText(StringName.PLACEMENT_COMPANY_DETAIL));
                List<PlacementCompanyPattern> companyPatternList = new ArrayList<>();
                subList = node.getChildren(StringName.PLACEMENT_COMPANY_PATTERN);
                for (Element subNode: subList)
                {
                    PlacementCompanyPattern companyPattern = new PlacementCompanyPattern();
                    companyPattern.setRoundId(subNode.getChildText(StringName.PLACEMENT_COMPANY_PATTERN_ROUND_ID));
                    companyPattern.setRoundName(subNode.getChildText(StringName.PLACEMENT_COMPANY_PATTERN_ROUND_NAME));
                    companyPattern.setRoundDetail(subNode.getChildText(StringName.PLACEMENT_COMPANY_PATTERN_ROUND_DETAIL));
                    companyPatternList.add(companyPattern);
                }
                placementCompany.setCompanyPatternList(companyPatternList);
                placementCompany.setCompanyDocument(node.getChildText(StringName.PLACEMENT_COMPANY_DOCUMENTS));
                List<PlacementCompanyLink> companyLinks = new ArrayList<>();
                subList = node.getChildren(StringName.PLACEMENT_COMPANY_LINK);
                for (Element subNode: subList) {
                    PlacementCompanyLink companyLink = new PlacementCompanyLink();
                    companyLink.setLinktext(subNode.getChildText(StringName.PLACEMENT_COMPANY_LINK_TEXT));
                    companyLink.setLinkDesc(subNode.getChildText(StringName.PLACEMENT_COMPANY_LINK_DESC));
                    companyLink.setLinkDesc(companyLink.getLinkDesc().trim());
                    companyLinks.add(companyLink);
                }
                placementCompany.setCompanyLinkList(companyLinks);
                placementCompany.setCompanyEligibilityCriteria(node.getChildText(StringName.PLACEMENT_COMPANY_ELIGIBILITY));
                this.getPlacementCompanies().add(placementCompany);
            }

        }
        catch (Exception e)
        {
            Log.e(StringName.MAIN_PLACEMENT,e.getMessage());
        }
        return this.getPlacementCompanies();
    }
}
