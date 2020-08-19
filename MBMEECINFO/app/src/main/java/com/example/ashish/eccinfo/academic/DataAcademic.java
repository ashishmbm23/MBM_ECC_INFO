package com.example.ashish.eccinfo.academic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 8/20/2017.
 */

public class DataAcademic implements Serializable {

    private static List<String> academics ;

    public static List<String> getAcademics() {
        return academics;
    }

    static
    {
        academics = new ArrayList<>();
        academics.add("External download links");
        academics.add("Workshop information and Procedure");
        academics.add("Mandatory Internship and Training Programme");
        academics.add("Final Year Project Information");
    }


}
