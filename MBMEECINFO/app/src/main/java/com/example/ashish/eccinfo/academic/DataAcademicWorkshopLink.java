package com.example.ashish.eccinfo.academic;

import com.example.ashish.eccinfo.stringConstant.StringName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 8/20/2017.
 */

public class DataAcademicWorkshopLink implements Serializable {

    private static List<DataAcedemicDownloadModel> dowloadList;

    public static List<DataAcedemicDownloadModel> getDowloadList() {
        return dowloadList;
    }

    public static void setDowloadList(List<DataAcedemicDownloadModel> dowloadList) {
        DataAcademicWorkshopLink.dowloadList = dowloadList;
    }

    static
    {
        dowloadList = new ArrayList<>();
        dowloadList.add(new DataAcedemicDownloadModel("DIP Trace layout tutorial", StringName.ACADEMIC_WORKSHOP_DIP_TRACE_LAYOUT));
        dowloadList.add(new DataAcedemicDownloadModel("DIP Trace Schematic tutorial", StringName.ACADEMIC_WORKSHOP_DIP_TRACE_SCHEMATIC));
        dowloadList.add(new DataAcedemicDownloadModel("DIP Trace PCB design e-book", StringName.ACADEMIC_WORKSHOP_DIP_TRACE_BOOK));
        dowloadList.add(new DataAcedemicDownloadModel("NI Ultiboard PCB Design tutorial", StringName.ACADEMIC_WORKSHOP_ULTIBOARD));
        dowloadList.add(new DataAcedemicDownloadModel("NI Ultiboard PCB Design e-book", StringName.ACADEMIC_WORKSHOP_ULTIBOARD_DESIGN));
        dowloadList.add(new DataAcedemicDownloadModel("Autodesk Eagle PCB Design tutorial", StringName.ACADEMIC_WORKSHOP_EAGLE));
        dowloadList.add(new DataAcedemicDownloadModel("Autodesk Eagle PCB Design documentation", StringName.ACADEMIC_WORKSHOP_EAGLE_DOCUMENTATION));
        dowloadList.add(new DataAcedemicDownloadModel("Electronics for you website link", StringName.ACADEMIC_WORKSHOP_EFY_LINK));
        dowloadList.add(new DataAcedemicDownloadModel("Electronics for you sample project download", StringName.ACADEMIC_WORKSHOP_EFY_PROJECT));

    }
}
