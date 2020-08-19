package com.example.ashish.eccinfo.data;

import com.example.ashish.eccinfo.Semester;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 7/23/2017.
 */

public class DataSemester {
    private static List<Semester> dataSemester = new ArrayList<>();

    static
    {
        dataSemester.add(new Semester("1", "Semester 1"));
        dataSemester.add(new Semester("2", "Semester 2"));
        dataSemester.add(new Semester("3", "Semester 3"));
        dataSemester.add(new Semester("4", "Semester 4"));
        dataSemester.add(new Semester("5", "Semester 5"));
        dataSemester.add(new Semester("6", "Semester 6"));
        dataSemester.add(new Semester("7", "Semester 7"));
        dataSemester.add(new Semester("8", "Semester 8"));
    }

    public static List<Semester> getDataSemester()
    {
        return dataSemester;
    }
}
