package com.example.ashish.eccinfo.academic;

import com.example.ashish.eccinfo.stringConstant.StringName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 8/20/2017.
 */

public class DataAcedemicDownload implements Serializable {

    private static List<DataAcedemicDownloadModel> dowloadList;

    public static List<DataAcedemicDownloadModel> getDowloadList() {
        return dowloadList;
    }

    public static void setDowloadList(List<DataAcedemicDownloadModel> dowloadList) {
        DataAcedemicDownload.dowloadList = dowloadList;
    }

    static
    {
        dowloadList = new ArrayList<>();
        dowloadList.add(new DataAcedemicDownloadModel("Semester 5 Practical Lab Material", StringName.ACADEMIC_DOWNLOAD_SEM5_PRACTICAL));
        dowloadList.add(new DataAcedemicDownloadModel("Semester 6 Theory Material", StringName.ACADEMIC_DOWNLOAD_SEM6_STUDY));
        dowloadList.add(new DataAcedemicDownloadModel("Semester 6 Practical Lab Material", StringName.ACADEMIC_DOWNLOAD_SEM6_PRACTICAL));
        dowloadList.add(new DataAcedemicDownloadModel("Semester 6 Practical Lab Material", StringName.ACADEMIC_DOWNLOAD_SEM6_PRACTICAL));
        dowloadList.add(new DataAcedemicDownloadModel("Semester 7 VLSI Theory Material", StringName.ACADEMIC_DOWNLOAD_SEM7_STUDY_VLSI));
        dowloadList.add(new DataAcedemicDownloadModel("Semester 7 Oprical Fibre Communication Theory Material", StringName.ACADEMIC_DOWNLOAD_SEM7_STUDY_OFC));
        dowloadList.add(new DataAcedemicDownloadModel("Semester 7 Practical Lab Material", StringName.ACADEMIC_DOWNLOAD_SEM7_PRACTICAL));
        dowloadList.add(new DataAcedemicDownloadModel("Semester 7 Theory Material", StringName.ACADEMIC_DOWNLOAD_SEM7_STUDY));
        dowloadList.add(new DataAcedemicDownloadModel("Semester 8 Practical Lab Material", StringName.ACADEMIC_DOWNLOAD_SEM8_PRACTICAL));
        dowloadList.add(new DataAcedemicDownloadModel("Semester 8 Practical Lab Material", StringName.ACADEMIC_DOWNLOAD_SEM8_PRACTICAL_WANDM));

    }


}
