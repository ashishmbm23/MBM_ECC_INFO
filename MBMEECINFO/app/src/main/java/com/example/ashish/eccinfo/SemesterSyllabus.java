package com.example.ashish.eccinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.ashish.eccinfo.data.Subject;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Ashish on 7/23/2017.
 */

public class SemesterSyllabus extends Activity {
    public static String getSemId() {
        return SEM_ID;
    }

    public static void setSemId(String semId) {
        SEM_ID = semId;
    }

    public static String getSemesterName() {
        return SEMESTER_NAME;
    }

    public static void setSemesterName(String semesterName) {
        SEMESTER_NAME = semesterName;
    }

    public static String getSubjectBook() {
        return SUBJECT_BOOK;
    }

    public static String getSubjectId() {
        return SUBJECT_ID;
    }

    public static String getSubjectName() {
        return SUBJECT_NAME;
    }

    public static String getSubjectSyllabus() {
        return SUBJECT_SYLLABUS;
    }

    public static String SEM_ID;
    public static String SEMESTER_NAME = "";
    public static final String SUBJECT_BOOK = "book";
    public static final String SUBJECT_ID = "subID";
    public static final String SUBJECT_NAME = "subName";
    public static final String SUBJECT_SYLLABUS = "subSyllabus";
    public static final int SEMESTER_SYLLABUS_CODE = 102;
    List<Subject> subjectList;
    private void displayDetail(Subject paramSubject)
    {
        Intent localIntent = new Intent(this, SemesterSubject.class);
        localIntent.putExtra("subID", paramSubject.getSubID());
        localIntent.putExtra("subName", paramSubject.getSubName());
        localIntent.putExtra("subSyllabus", paramSubject.getSubSyllabus());
        localIntent.putExtra("book", paramSubject.getBook());
        startActivityForResult(localIntent,SEMESTER_SYLLABUS_CODE);
    }

    protected void onCreate(final Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_semester_list);
       // new AppCompatActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SEMESTER_NAME = getIntent().getStringExtra("semesterName");
        TextView tv = (TextView) findViewById(R.id.textView_title);
        tv.setText(SEMESTER_NAME);
       /// ((TextView)findViewById(2131624102)).setText(paramBundle);
        subjectList = new ArrayList<>();
        this.setSemId(getIntent().getStringExtra("semesterId"));
        subjectList = new SyllabusJDOMParser().parseXML(this,this);
        ArrayAdapter localArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, subjectList);
        ListView localListView = (ListView)findViewById(R.id.listView_semester);
        localListView.setAdapter(localArrayAdapter);

        localListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Subject subject = subjectList.get(position);
                displayDetail(subject);
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
            getIntent().putExtra("resultMessage", SEMESTER_NAME);
            setResult(RESULT_OK,getIntent());
            finish();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == SEMESTER_SYLLABUS_CODE)
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
