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
import com.example.ashish.eccinfo.stringConstant.StringName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 7/23/2017.
 */

public class ExamPatternDisplay extends Activity {

    private  String SEMESTER_ID;
    private   String SEMESTER_NAME;
    private   String SEMESTER_PRACTICAL;
    private SemesterExam semesterExam = new SemesterExam();

    public SemesterExam getSemesterExam() {
        return semesterExam;
    }

    public void setSemesterExam(SemesterExam semesterExam) {
        this.semesterExam = semesterExam;
    }

    public String getSEMESTER_ID() {
        return SEMESTER_ID;
    }

    public void setSEMESTER_ID(String SEMESTER_ID) {
        this.SEMESTER_ID = SEMESTER_ID;
    }

    public String getSEMESTER_NAME() {
        return SEMESTER_NAME;
    }

    public void setSEMESTER_NAME(String SEMESTER_NAME) {
        this.SEMESTER_NAME = SEMESTER_NAME;
    }

    public String getSEMESTER_PRACTICAL() {
        return SEMESTER_PRACTICAL;
    }

    public void setSEMESTER_PRACTICAL(String SEMESTER_PRACTICAL) {
        this.SEMESTER_PRACTICAL = SEMESTER_PRACTICAL;
    }

    public String getSEMESTER_WRITTEN() {
        return SEMESTER_WRITTEN;
    }

    public void setSEMESTER_WRITTEN(String SEMESTER_WRITTEN) {
        this.SEMESTER_WRITTEN = SEMESTER_WRITTEN;
    }

    private String SEMESTER_WRITTEN;

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_semester_list);
       // SEMESTER_ID = getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_ID);
        this.setSEMESTER_ID(getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_ID));
        this.setSEMESTER_NAME(getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_NAME));
        this.setSEMESTER_WRITTEN(getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_WRITTEN));
        this.setSEMESTER_PRACTICAL(getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_PRACTICAL));
        this.setSemesterExam((SemesterExam) getIntent().getSerializableExtra(StringName.EXAM_PATTERN_OBJECT));
      /*  SEMESTER_NAME = getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_NAME);
        SEMESTER_WRITTEN = getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_WRITTEN);
        SEMESTER_PRACTICAL = getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_PRACTICAL);*/

        TextView tv = (TextView) findViewById(R.id.textView_title);
        tv.setText(this.getSEMESTER_NAME());

        List<String> list = new ArrayList<>();
        list.add(0, "Exam pattern of written exam");
        list.add(1, "Exam pattern of practical exam");
        list.add(2, "Display exam pattern as image");

        ArrayAdapter localArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        ListView localListView = (ListView)findViewById(R.id.listView_semester);
        localListView.setAdapter(localArrayAdapter);

        localListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0)
                    displayWritten();
                else if(position == 1)
                    displayPractical();
                else if(position == 2)
                {
                    displayImage();
                }
            }
        });
    }

    public void displayWritten()
    {
        Intent localIntent = new Intent(this, ExamPatternSemesterDisplay.class);
        localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_ID, this.getSEMESTER_ID());
        localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_NAME, this.getSEMESTER_NAME());
        localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_WRITTEN, this.getSEMESTER_WRITTEN());
        localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_PRACTICAL, this.getSEMESTER_PRACTICAL());
        localIntent.putExtra(StringName.EXAM_PATTERN_OBJECT, this.getSemesterExam());
        localIntent.putExtra(StringName.EXAM_PATTERN_DISPLAY_ID, "0");
        startActivityForResult(localIntent,StringName.EXAM_PATTERN_DISPLAY_CODE);
    }
    public void displayPractical()
    {
        Intent localIntent = new Intent(this, ExamPatternSemesterDisplay.class);
        localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_ID, this.getSEMESTER_ID());
        localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_NAME, this.getSEMESTER_NAME());
        localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_WRITTEN, this.getSEMESTER_WRITTEN());
        localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_PRACTICAL, this.getSEMESTER_PRACTICAL());
        localIntent.putExtra(StringName.EXAM_PATTERN_OBJECT, this.getSemesterExam());
        localIntent.putExtra(StringName.EXAM_PATTERN_DISPLAY_ID, "1");
        startActivityForResult(localIntent,StringName.EXAM_PATTERN_DISPLAY_CODE);
    }

    public void displayImage()
    {
        Intent localIntent = new Intent(this, ExamPatternShowImage.class);
        localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_ID, this.getSEMESTER_ID());
        localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_NAME, this.getSEMESTER_NAME());
        //localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_WRITTEN, this.getSEMESTER_WRITTEN());
        //localIntent.putExtra(StringName.EXAM_PATTERN_SEMESTER_PRACTICAL, this.getSEMESTER_PRACTICAL());
        //localIntent.putExtra(StringName.EXAM_PATTERN_OBJECT, this.getSemesterExam());
        //localIntent.putExtra(StringName.EXAM_PATTERN_DISPLAY_ID, "2");
        startActivityForResult(localIntent,StringName.EXAM_PATTERN_DISPLAY_CODE);
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
        if(requestCode == StringName.EXAM_PATTERN_DISPLAY_CODE)
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
}
