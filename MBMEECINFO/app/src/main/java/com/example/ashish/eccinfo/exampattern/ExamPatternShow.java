package com.example.ashish.eccinfo.exampattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ashish.eccinfo.R;
import com.example.ashish.eccinfo.Semester;
import com.example.ashish.eccinfo.stringConstant.StringName;

import java.util.List;

/**
 * Created by Ashish on 7/23/2017.
 */

public class ExamPatternShow extends Activity {
    public static final String SEMESTER_ID = "semesterId";
    public static final String SEMESTER_NAME = "semesterName";
    public static final int SEMESTER_EXAM_CODE = 201;
    List<SemesterExam> semesterExamList;
    protected void onCreate(final Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_semester_list);

        String exam = getIntent().getStringExtra("exam");

        TextView tv = (TextView) findViewById(R.id.textView_title);

        tv.setText(exam + " Pattern");

        //semesterList = DataSemester.getDataSemester();
        semesterExamList = new ExamPatternJDOMParser().parseXML(this);
        ArrayAdapter<Semester> localArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, semesterExamList);
        ListView localListView = (ListView)findViewById(R.id.listView_semester);
        localListView.setAdapter(localArrayAdapter);


        localListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SemesterExam semesterExam
                        =  semesterExamList.get(position);
                displayDetail(semesterExam);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu paramMenu)
    {
        getMenuInflater().inflate(R.menu.menu_main, paramMenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        if (paramMenuItem.getItemId() == R.id.action_settings)
            return true;
        else if(paramMenuItem.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == SEMESTER_EXAM_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                String msg = data.getStringExtra("resultMessage");
                TextView tv = (TextView) findViewById(R.id.textView_title);
                tv.setText(msg);
                //Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            }
        }
    }

    private void displayDetail(SemesterExam paramSemesterExam)
    {
        Intent localIntent = new Intent(this, ExamPatternDisplay.class);
        localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_ID, paramSemesterExam.getSemID());
        localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_NAME, paramSemesterExam.getSemName());
        localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_WRITTEN, paramSemesterExam.getSemWritten());
        localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_PRACTICAL, paramSemesterExam.getSemPractical());
        localIntent.putExtra(StringName.EXAM_PATTERN_OBJECT, paramSemesterExam);
        startActivity(localIntent);
    }
}
