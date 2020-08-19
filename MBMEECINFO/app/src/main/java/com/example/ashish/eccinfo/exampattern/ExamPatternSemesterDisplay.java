package com.example.ashish.eccinfo.exampattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ashish.eccinfo.R;
import com.example.ashish.eccinfo.stringConstant.StringName;

import java.util.ArrayList;

/**
 * Created by Ashish on 8/16/2017.
 */

public class ExamPatternSemesterDisplay extends Activity {
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
        setContentView(R.layout.activity_exam_pattern);
        // SEMESTER_ID = getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_ID);
        this.setSEMESTER_ID(getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_ID));
        this.setSEMESTER_NAME(getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_NAME));
        this.setSEMESTER_WRITTEN(getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_WRITTEN));
        this.setSEMESTER_PRACTICAL(getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_PRACTICAL));
        String display_id = getIntent().getStringExtra(StringName.EXAM_PATTERN_DISPLAY_ID);
        this.setSemesterExam((SemesterExam) getIntent().getSerializableExtra(StringName.EXAM_PATTERN_OBJECT));
      /*  SEMESTER_NAME = getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_NAME);
        SEMESTER_WRITTEN = getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_WRITTEN);
        SEMESTER_PRACTICAL = getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_PRACTICAL);*/

      TextView title = (TextView) findViewById(R.id.exam_textView_semester_name);
        if(display_id.equals("0"))
        {
            title.setText(this.getSEMESTER_NAME() + " Theory Exam");
        }
        else
        {
            title.setText(this.getSEMESTER_NAME() + " Practical Exam");
        }

         SemesterExam semesterExam = this.getSemesterExam();
        if(display_id.equals("0"))
        {
            ArrayList<SubjectExam> subjectsWritten = this.getSemesterExam().getSubjectWritten();
            int row = 2;
            int col = 1;
            for (SubjectExam subjectExam:subjectsWritten ) {
                TextView tv = (TextView) findViewById(getResourceId(row,col));
                tv.setText(subjectExam.getSUBJECT_NAME());
                col++;
                TextView tv1 = (TextView) findViewById(getResourceId(row,col));
                tv1.setText(subjectExam.getSUBJECT_MARKS());
                row++;
                col = 1;
            }
        }
        else if(display_id.equals("1"))
        {
            ArrayList<SubjectExam> subjectsPractical = this.getSemesterExam().getSubjectPractical();
            int row = 2;
            int col = 1;
            for (SubjectExam subjectExam:subjectsPractical ) {
                TextView tv = (TextView) findViewById(getResourceId(row,col));
                tv.setText(subjectExam.getSUBJECT_NAME());
                col++;
                TextView tv1 = (TextView) findViewById(getResourceId(row,col));
                tv1.setText(subjectExam.getSUBJECT_MARKS());
                row++;
                col = 1;
            }
        }



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


    private int getResourceId(int row, int column)
    {
        //String str = "exam_pattern_table_tv_r" + row + "c" + coulumn;
     /*   if(row == 1 && column == 1)
        {
            return R.id.exam_pattern_table_tv_r1c1;
        }
        else if(row == 1 && column == 2)
        {
            return R.id.exam_pattern_table_tv_r1c2;
        }*/
        if(row == 2 && column == 1)
        {
            return R.id.exam_pattern_table_tv_r2c1;
        }
        else if(row == 2 && column == 2)
        {
            return R.id.exam_pattern_table_tv_r2c2;
        }
        else if(row == 3 && column == 1)
        {
            return R.id.exam_pattern_table_tv_r3c1;
        }
        else if(row == 3 && column == 2)
        {
            return R.id.exam_pattern_table_tv_r3c2;
        }
        else  if(row == 4 && column == 1)
        {
            return R.id.exam_pattern_table_tv_r4c1;
        }
        else if(row == 4 && column == 2)
        {
            return R.id.exam_pattern_table_tv_r4c2;
        }
        else if(row == 5 && column == 1)
        {
            return R.id.exam_pattern_table_tv_r5c1;
        }
        else if(row == 5 && column == 2)
        {
            return R.id.exam_pattern_table_tv_r5c2;
        }
        else  if(row == 6 && column == 1)
        {
            return R.id.exam_pattern_table_tv_r6c1;
        }
        else if(row == 6 && column == 2)
        {
            return R.id.exam_pattern_table_tv_r6c2;
        }
        else  if(row == 7 && column == 1)
        {
            return R.id.exam_pattern_table_tv_r7c1;
        }
        else if(row == 7 && column == 2)
        {
            return R.id.exam_pattern_table_tv_r7c2;
        }
        else if(row == 8 && column == 1)
        {
            return R.id.exam_pattern_table_tv_r8c1;
        }
        else if(row == 8 && column == 2)
        {
            return R.id.exam_pattern_table_tv_r8c2;
        }
        else if(row == 9 && column == 1)
        {
            return R.id.exam_pattern_table_tv_r9c1;
        }
        else if(row == 9 && column == 2)
        {
            return R.id.exam_pattern_table_tv_r9c2;
        }
        return 1;
    }
}
