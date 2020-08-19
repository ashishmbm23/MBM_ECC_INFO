package com.example.ashish.eccinfo.aftercollege;

import android.content.Context;
import android.util.Log;

import com.example.ashish.eccinfo.R;
import com.example.ashish.eccinfo.academic.DataAcedemicDownloadModel;
import com.example.ashish.eccinfo.stringConstant.StringName;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 8/22/2017.
 */

public class AfterCollegeJDOMParser {

    List<PostCollege> postCollegeList = new ArrayList<>();

    public List<PostCollege> getPostCollegeList() {
        return postCollegeList;
    }

    public void setPostCollegeList(List<PostCollege> postCollegeList) {
        this.postCollegeList = postCollegeList;
    }

    public List<PostCollege> parseXML(Context paramContext)
    {
        InputStream stream = paramContext.getResources().openRawResource(R.raw.after_college);
        SAXBuilder saxBuilder = new SAXBuilder();

        List<Element> list = new ArrayList<>();
        List<Element> subList = new ArrayList<>();
        try
        {
            Document document = saxBuilder.build(stream);
            Element rootNode = document.getRootElement();
            list = rootNode.getChildren(StringName.MAIN_AFTER_COLLEGE_POST_COLLEGE);
            for (Element node : list) {
                PostCollege college = new PostCollege();
                college.setPostCollegeId(node.getChildText(StringName.MAIN_AFTER_COLLEGE_POST_COLLEGE_ID));
                college.setPostCollegeName(node.getChildText(StringName.MAIN_AFTER_COLLEGE_POST_COLLEGE_NAME));
                college.setDocument(node.getChildText(StringName.MAIN_AFTER_COLLEGE_POST_COLLEGE_DOCUMENT));
                college.setProcedure(node.getChildText(StringName.MAIN_AFTER_COLLEGE_POST_COLLEGE_PROCEDURE));
                List<DataAcedemicDownloadModel> downloadModels = new ArrayList<>();
                subList = node.getChildren(StringName.MAIN_AFTER_COLLEGE_POST_COLLEGE_LINK);
                for(Element subNode : subList)
                {
                    DataAcedemicDownloadModel downloadModel = new DataAcedemicDownloadModel();
                    downloadModel.setDownloadLink(subNode.getChildText(StringName.MAIN_AFTER_COLLEGE_POST_COLLEGE_LINK_DESC));
                    downloadModel.setDownloadText(subNode.getChildText(StringName.MAIN_AFTER_COLLEGE_POST_COLLEGE_LINK_TEXT));
                    downloadModels.add(downloadModel);
                }
                college.setDownloadLinks(downloadModels);
                this.postCollegeList.add(college);
            }

        }
        catch(Exception e)
        {
            Log.e(StringName.MAIN_AFTER_COLLEGE,e.getMessage());
        }
        return postCollegeList;
    }
}
