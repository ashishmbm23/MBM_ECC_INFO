package com.example.ashish.eccinfo;

import android.content.Context;
import android.util.Log;

import com.example.ashish.eccinfo.data.*;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 7/23/2017.
 */

public class SyllabusJDOMParser {
    private static final String LOGTAG = "MBM_ECC_INFO_SYLLABUS";
    private static final String BOOK = "book";
    private static final String SUBJECT_TAG = "subject";
    private static final String SUB_ID = "subID";
    private static final String SUB_NAME = "subName";
    private static final String SUB_SYLLABUS = "subSyllabus";

    public List<Subject>parseXML(Context paramContext, com.example.ashish.eccinfo.SemesterSyllabus semesterSyllabus)
    {
            String Semester_id = semesterSyllabus.getSemId();
            int id = Integer.parseInt(Semester_id);

            InputStream stream = paramContext.getResources().openRawResource(getRawSourceId(id));
            SAXBuilder builder = new SAXBuilder();
            List<Subject> subjects = new ArrayList<>();
            try
            {
                Document document = builder.build(stream);
                Element rootNode = document.getRootElement();
                List<Element> list = rootNode.getChildren(SUBJECT_TAG);

                for (Element node: list) {
                    Subject subject = new Subject();
                    subject.setSubID(node.getChildText(SUB_ID));
                    subject.setBook(node.getChildText(BOOK));
                    subject.setSubName(node.getChildText(SUB_NAME));
                    subject.setSubSyllabus(node.getChildText(SUB_SYLLABUS));
                    subjects.add(subject);
                }
            }
            catch (IOException | JDOMException e )
            {
                Log.d(LOGTAG, e.getMessage());
            }

            return subjects;
    }

    public int getRawSourceId(int id)
    {
        switch(id)
        {
            case 1 : return R.raw.sem_1;
            case 2 : return R.raw.sem_2;
            case 3 : return R.raw.sem_3;
            case 4 : return R.raw.sem_4;
            case 5 : return R.raw.sem_5;
            case 6 : return R.raw.sem_6;
            case 7 : return R.raw.sem_7;
            case 8 : return R.raw.sem_8;
            default:return 0;
        }
    }
}
