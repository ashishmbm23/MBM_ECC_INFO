package com.example.ashish.eccinfo.exampattern;

import java.io.Serializable;

/**
 * Created by Ashish on 8/19/2017.
 */

public class SubjectExam implements Serializable{
    private String SUBJECT_NAME;
    private String SUBJECT_MARKS;

    public String getSUBJECT_NAME() {
        return SUBJECT_NAME;
    }

    public void setSUBJECT_NAME(String SUBJECT_NAME) {
        this.SUBJECT_NAME = SUBJECT_NAME;
    }

    public String getSUBJECT_MARKS() {
        return SUBJECT_MARKS;
    }

    public void setSUBJECT_MARKS(String SUBJECT_MARKS) {
        this.SUBJECT_MARKS = SUBJECT_MARKS;
    }
}
