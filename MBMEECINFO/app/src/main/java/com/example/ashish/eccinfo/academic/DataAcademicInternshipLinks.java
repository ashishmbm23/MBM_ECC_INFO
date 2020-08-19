package com.example.ashish.eccinfo.academic;

import com.example.ashish.eccinfo.stringConstant.StringName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 8/21/2017.
 */

public class DataAcademicInternshipLinks implements Serializable {

    private static List<DataAcedemicDownloadModel> dowloadList;

    public static List<DataAcedemicDownloadModel> getDowloadList() {
        return dowloadList;
    }

    public static void setDowloadList(List<DataAcedemicDownloadModel> dowloadList) {
        DataAcademicInternshipLinks.dowloadList = dowloadList;
    }

    static
    {
        dowloadList = new ArrayList<>();
        dowloadList.add(new DataAcedemicDownloadModel("Internship Joining Report Format", StringName.ACADEMIC_INTERNSHIP_JOINING_REPORT));
        dowloadList.add(new DataAcedemicDownloadModel("Internship Training Report Format", StringName.ACADEMIC_INTERNSHIP_TRAINING_REPORT));
    }
}
