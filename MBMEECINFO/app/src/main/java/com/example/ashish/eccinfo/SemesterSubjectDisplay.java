package com.example.ashish.eccinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Ashish on 8/8/2017.
 */

public class SemesterSubjectDisplay extends Activity {

    public static String SUB_BOOK;
    public static String SUB_ID;
    public static String SUB_NAME;
    public static String SUB_SYLLABUS;
    public static final int SEMESTER_SUBJECT_DISPLAY_CODE = 104;
    public static String getSubBook() {
        return SUB_BOOK;
    }

    public static void setSubBook(String subBook) {
        SUB_BOOK = subBook;
    }

    public static String getSubId() {
        return SUB_ID;
    }

    public static void setSubId(String subId) {
        SUB_ID = subId;
    }

    public static String getSubName() {
        return SUB_NAME;
    }

    public static void setSubName(String subName) {
        SUB_NAME = subName;
    }

    public static String getSubSyllabus() {
        return SUB_SYLLABUS;
    }

    public static void setSubSyllabus(String subSyllabus) {
        SUB_SYLLABUS = subSyllabus;
    }

    public static String getSubDisplayId() {
        return SUB_DISPLAY_ID;
    }

    public static void setSubDisplayId(String subDisplayId) {
        SUB_DISPLAY_ID = subDisplayId;
    }

    public static String SUB_DISPLAY_ID ;

    protected void onCreate(final Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_subject);
        //new AppCompatActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setSubSyllabus(getIntent().getStringExtra("subSyllabus"));
        this.setSubName(getIntent().getStringExtra("subName"));
        this.setSubBook( getIntent().getStringExtra("book"));
        this.setSubDisplayId( getIntent().getStringExtra("subDisplayId"));
        this.setSubId(getIntent().getStringExtra("subID"));

        TextView textViewTitle= (TextView) findViewById(R.id.textView_subjectName);
        textViewTitle.setText(this.getSubName());

        TextView textViewDetail= (TextView) findViewById(R.id.textView_show_sub);


        if(this.getSubDisplayId().equals("0"))
        {
            textViewDetail.setText(this.getSubSyllabus());
        }
        else if(this.getSubDisplayId().equals("1"))
        {
            textViewDetail.setText(this.getSubBook());
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
            getIntent().putExtra("resultMessage", this.getSubName());
            setResult(RESULT_OK,getIntent());
            finish();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == SEMESTER_SUBJECT_DISPLAY_CODE)
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
