package com.example.ashish.eccinfo.data;

/**
 * Created by Ashish on 7/23/2017.
 */

public class Subject {
    private String book;
    private String subID;
    private String subName;
    private String subSyllabus;

    public String getBook()
    {
        return this.book;
    }

    public String getSubID()
    {
        return this.subID;
    }

    public String getSubName()
    {
        return this.subName;
    }

    public String getSubSyllabus()
    {
        return this.subSyllabus;
    }

    public void setBook(String paramString)
    {
        this.book = paramString;
    }

    public void setSubID(String paramString)
    {
        this.subID = paramString;
    }

    public void setSubName(String paramString)
    {
        this.subName = paramString;
    }

    public void setSubSyllabus(String paramString)
    {
        this.subSyllabus = paramString;
    }

    public String toString()
    {
        return this.subName;
    }
}
