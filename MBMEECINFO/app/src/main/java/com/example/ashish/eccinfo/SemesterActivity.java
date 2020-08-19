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

import com.example.ashish.eccinfo.data.DataSemester;
import java.util.List;
/**
 * Created by Ashish on 7/23/2017.
 */

public class SemesterActivity extends Activity {

    public static final String SEMESTER_ID = "semesterId";
    public static final String SEMESTER_NAME = "semesterName";
    public static final int SEMESTER_CODE = 101;
    List<Semester> semesterList;
    private void displayDetail(Semester paramSemester)
    {
        Intent localIntent = new Intent(this, SemesterSyllabus.class);
        localIntent.putExtra("semesterId", paramSemester.getSemesterId());
        localIntent.putExtra("semesterName", paramSemester.getSemesterName());
        startActivityForResult(localIntent, SEMESTER_CODE);
    }

    protected void onCreate(final Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_semester_list);
       // new  AppCompatActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String semester = getIntent().getStringExtra("Semester");
        //paramBundle = getIntent().getStringExtra("Semester");
        TextView tv = (TextView) findViewById(R.id.textView_title);
       // ((TextView)findViewById(2131624102)).setText(paramBundle);
        tv.setText(semester);

        semesterList = DataSemester.getDataSemester();
        ArrayAdapter<Semester> localArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, semesterList);
        ListView localListView = (ListView)findViewById(R.id.listView_semester);
        localListView.setAdapter(localArrayAdapter);
        /*localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
                paramAnonymousAdapterView = (Semester)paramBundle.get(paramAnonymousInt);
                SemesterActivity.this.displayDetail(paramAnonymousAdapterView);
            }
        });*/

        localListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Semester semester1 =  semesterList.get(position);
                displayDetail(semester1);
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
        if(requestCode == SEMESTER_CODE)
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
