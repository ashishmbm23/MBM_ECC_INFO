package com.example.ashish.eccinfo.exampattern;

import android.content.Context;

import com.example.ashish.eccinfo.R;
import com.example.ashish.eccinfo.stringConstant.StringName;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
/**
 * Created by Ashish on 7/23/2017.
 */

public class ExamPatternJDOMParser {
    private static final String SEMESTER_ID = "semID";
    private static final String SEMESTER_NAME = "semName";
    private static final String SEMESTER_PRACTICAL = "semPractical";
    private static final String SEMESTER_TAG = "semesterExam";
    private static final String SEMESTER_WRITTEN = "semWriiten";
    public List<SemesterExam> parseXML(Context paramContext)
    {
       InputStream stream = paramContext.getResources().openRawResource(R.raw.exam);
        SAXBuilder saxBuilder = new SAXBuilder();
        List<SemesterExam> semesterExamList = new ArrayList();
        List<Element> list = new ArrayList<>();
        List<Element> subList = new ArrayList<>();

        try{
            Document document = saxBuilder.build(stream);
            Element rootNode = document.getRootElement();
            list = rootNode.getChildren(StringName.EXAM_PATTERN_SEMESTER_EXAM);
            for (Element node:list)
            {
                SemesterExam semesterExam = new SemesterExam();
                semesterExam.setSemID(node.getChildText(StringName.EXAM_PATTERN_SEMESTER_ID));
                semesterExam.setSemWritten((node.getChildText(StringName.EXAM_PATTERN_SEMESTER_WRITTEN)));
                semesterExam.setSemPractical(node.getChildText(StringName.EXAM_PATTERN_SEMESTER_PRACTICAL));
                semesterExam.setSemName(node.getChildText(StringName.EXAM_PATTERN_SEMESTER_NAME));
                ArrayList<SubjectExam> subjectWritten = semesterExam.getSubjectWritten();
                ArrayList<SubjectExam> subjectPractical = semesterExam.getSubjectPractical();
                subList = node.getChildren(StringName.EXAM_PATTERN_SUBJECT_WRITTEN);
                for (Element subNode: subList)
                {
                    SubjectExam subjectExam = new SubjectExam();
                    subjectExam.setSUBJECT_NAME(subNode.getChildText(StringName.EXAM_PATTERN_SUBJECT_NAME));
                    subjectExam.setSUBJECT_MARKS((subNode.getChildText(StringName.EXAM_PATTERN_SUBJECT_MARKS)));
                    subjectWritten.add(subjectExam);
                }
                semesterExam.setSubjectWritten(subjectWritten);

                subList = node.getChildren(StringName.EXAM_PATTERN_SUBJECT_PRACTICAL);
                for (Element subNode: subList)
                {
                    SubjectExam subjectExam = new SubjectExam();
                    subjectExam.setSUBJECT_NAME(subNode.getChildText(StringName.EXAM_PATTERN_SUBJECT_NAME));
                    subjectExam.setSUBJECT_MARKS((subNode.getChildText(StringName.EXAM_PATTERN_SUBJECT_MARKS)));
                    subjectPractical.add(subjectExam);
                }
                semesterExam.setSubjectPractical(subjectPractical);

                semesterExamList.add(semesterExam);
            }
        }
        catch(Exception e)
        {

        }


        return semesterExamList;
    }
}
