package com.example.ashish.eccinfo;

/**
 * Created by Ashish on 7/23/2017.
 */

public class Semester {
    private String semesterId;
    private String semesterName;

    public Semester(String paramString1, String paramString2)
    {
        this.semesterName = paramString2;
        this.semesterId = paramString1;
    }

    public String getSemesterId()
    {
        return this.semesterId;
    }

    public String getSemesterName()
    {
        return this.semesterName;
    }

    public void setSemesterId(String paramString)
    {
        this.semesterId = paramString;
    }

    public void setSemesterName(String paramString)
    {
        this.semesterName = paramString;
    }

    public String toString()
    {
        return this.semesterName;
    }
}
