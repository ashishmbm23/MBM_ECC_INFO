package com.example.ashish.eccinfo.exampattern;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ashish on 7/23/2017.
 */

public class SemesterExam implements Serializable{
    private String semID;
    private String semName;
    private String semPractical;
    private String semWritten;
    private ArrayList<SubjectExam> subjectWritten = new ArrayList<>();
    private ArrayList<SubjectExam> subjectPractical = new ArrayList<>();

    public ArrayList<SubjectExam> getSubjectWritten() {
        return subjectWritten;
    }

    public void setSubjectWritten(ArrayList<SubjectExam> subjectWritten) {
        this.subjectWritten = subjectWritten;
    }

    public ArrayList<SubjectExam> getSubjectPractical() {
        return subjectPractical;
    }

    public void setSubjectPractical(ArrayList<SubjectExam> subjectPractical) {
        this.subjectPractical = subjectPractical;
    }



    public String getSemID()
    {
        return this.semID;
    }

    public String getSemName()
    {
        return this.semName;
    }

    public String getSemPractical()
    {
        return this.semPractical;
    }

    public String getSemWritten()
    {
        return this.semWritten;
    }

    public void setSemID(String paramString)
    {
        this.semID = paramString;
    }

    public void setSemName(String paramString)
    {
        this.semName = paramString;
    }

    public void setSemPractical(String paramString)
    {
        this.semPractical = paramString;
    }

    public void setSemWritten(String paramString)
    {
        this.semWritten = paramString;
    }

    public String toString()
    {
        return this.semName;
    }
}
