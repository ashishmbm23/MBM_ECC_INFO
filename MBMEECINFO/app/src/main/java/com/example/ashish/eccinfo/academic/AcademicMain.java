package com.example.ashish.eccinfo.academic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class AcademicMain extends Activity{

    private String ACADEMIC;
    private List<String> academicList;

    public List<String> getAcademicList() {
        return academicList;
    }

    public void setAcademicList(List<String> academicList) {
        this.academicList = academicList;
    }

    public String getACADEMIC() {
        return ACADEMIC;
    }

    public void setACADEMIC(String ACADEMIC) {
        this.ACADEMIC = ACADEMIC;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_list);
        this.setACADEMIC(getIntent().getStringExtra(StringName.MAIN_ACADEMIC));

        TextView tv = (TextView) findViewById(R.id.textView_title);
        tv.setText(this.getACADEMIC() + " Information");

        this.setAcademicList(DataAcademic.getAcademics());

        ArrayAdapter<Semester> localArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, this.getAcademicList());
        ListView localListView = (ListView)findViewById(R.id.listView_semester);
        localListView.setAdapter(localArrayAdapter);

        localListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                displayDetail(position);
            }
        });

    }

    public void displayDetail(int position)
    {
        if(position == 0)
        {
            Intent intent = new Intent(this, ActivityDownloads.class);
            intent.putExtra(StringName.ACADEMIC_DOWNLOAD, StringName.ACADEMIC_DOWNLOAD);
            startActivity(intent);
        }
        else if(position == 1)
        {
            Intent intent = new Intent(this, AcademicWorkshop.class);
            intent.putExtra(StringName.ACADEMIC_WORKSHOP, StringName.ACADEMIC_WORKSHOP);
            startActivity(intent);
        }
        else if(position == 2)
        {
            Intent intent = new Intent(this, AcademicInternship.class);
            intent.putExtra(StringName.ACADEMIC_INTERNSHIP, StringName.ACADEMIC_INTERNSHIP);
            startActivity(intent);
        }
        else if(position == 3)
        {
            Intent intent = new Intent(this, AcademicFinalYearProject.class);
            intent.putExtra(StringName.ACADEMIC_PROJECT, StringName.ACADEMIC_PROJECT);
            startActivity(intent);
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

   /* @Override
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
    }*/
}
