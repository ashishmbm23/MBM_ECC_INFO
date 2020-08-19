package com.example.ashish.eccinfo;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 7/23/2017.
 */

public class SemesterSubject extends Activity {
    public static String SUB_BOOK;
    public static String SUB_ID;
    public static String SUB_NAME;
    public static String SUB_SYLLABUS;
    public static String SUB_DISPLAY_ID = "subDisplayId";
    public static final int SEMESTER_SUBJECT_CODE = 103;

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
    /*public void btnClickHandleBook(View paramView)
    {
        ((TextView)findViewById(2131624107)).setText(SUB_BOOK);
    }

    public void btnClickHandleSyllabus(View paramView)
    {
        ((TextView)findViewById(2131624107)).setText(SUB_SYLLABUS);
    }*/

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_semester_list);
        SUB_NAME = getIntent().getStringExtra("subName");
        SUB_ID = getIntent().getStringExtra("subID");
        SUB_SYLLABUS = getIntent().getStringExtra("subSyllabus");
        SUB_BOOK = getIntent().getStringExtra("book");
       /* ((TextView)findViewById(2131624104)).setText(SUB_NAME);
        ((Button)findViewById(2131624105)).setText(2131165277);
        ((Button)findViewById(2131624106)).setText(2131165276);*/
        TextView tv = (TextView) findViewById(R.id.textView_title);
        tv.setText(SUB_NAME);

        List<String> list = new ArrayList<>();
        list.add(0, "Syllabus of the subject");
        list.add(1, "Referance Books for the subject");

        ArrayAdapter localArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        ListView localListView = (ListView)findViewById(R.id.listView_semester);
        localListView.setAdapter(localArrayAdapter);

        localListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0)
                    displaySyllabus();
                else if(position == 1)
                    displayBooks();
            }
        });
    }

    private void displaySyllabus()
    {
        Intent localIntent = new Intent(this, SemesterSubjectDisplay.class);
        localIntent.putExtra("subID", this.getSubId());
        localIntent.putExtra("subName", this.getSubName());
        localIntent.putExtra("subSyllabus", this.getSubSyllabus());
        localIntent.putExtra("book", this.getSubBook());
        localIntent.putExtra(SUB_DISPLAY_ID, "0");
        startActivityForResult(localIntent,SEMESTER_SUBJECT_CODE);
    }
    private void displayBooks()
    {
        Intent localIntent = new Intent(this, SemesterSubjectDisplay.class);
        localIntent.putExtra("subID", this.getSubId());
        localIntent.putExtra("subName", this.getSubName());
        localIntent.putExtra("subSyllabus",  this.getSubSyllabus());
        localIntent.putExtra("book", this.getSubBook());
        localIntent.putExtra(SUB_DISPLAY_ID, "1");
        startActivityForResult(localIntent,SEMESTER_SUBJECT_CODE);
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
            getIntent().putExtra("resultMessage", SUB_NAME);
            setResult(RESULT_OK,getIntent());
            finish();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == SEMESTER_SUBJECT_CODE)
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
