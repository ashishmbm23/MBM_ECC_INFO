package com.example.ashish.eccinfo.aftercollege;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 7/23/2017.
 */

public class AfterCollegeActivity extends Activity {
    private String AFTER_COLLEGE;
    private List<PostCollege> collegeList = new ArrayList<>();

    public List<PostCollege> getCollegeList() {
        return collegeList;
    }

    public void setCollegeList(List<PostCollege> collegeList) {
        this.collegeList = collegeList;
    }

    public String getAFTER_COLLEGE() {
        return AFTER_COLLEGE;
    }

    public void setAFTER_COLLEGE(String AFTER_COLLEGE) {
        this.AFTER_COLLEGE = AFTER_COLLEGE;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_list);
        this.setAFTER_COLLEGE(getIntent().getStringExtra(StringName.MAIN_MAIN));

        TextView tv = (TextView) findViewById(R.id.textView_title);
        tv.setText(this.getAFTER_COLLEGE());

        this.setCollegeList(new AfterCollegeJDOMParser().parseXML(getApplicationContext()));

        ArrayAdapter<Semester> localArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, this.getCollegeList());
        ListView localListView = (ListView)findViewById(R.id.listView_semester);
        localListView.setAdapter(localArrayAdapter);

        localListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PostCollege college = collegeList.get(position);
                displayDetail(college);
            }
        });

    }

    public void displayDetail(PostCollege college)
    {
        Intent intent = new Intent(this, PostCollegeDisplay.class);
        intent.putExtra(StringName.MAIN_AFTER_COLLEGE_OBJECT,college);
        startActivity(intent);
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

}
