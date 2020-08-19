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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 7/23/2017.
 */

public class AcademicFinalYearProject extends Activity {
    private  String ACADEMIC_PROJECT;
    private DataWorkshop dataWorkshop;

    public DataWorkshop getDataWorkshop() {
        return dataWorkshop;
    }

    public void setDataWorkshop(DataWorkshop dataWorkshop) {
        this.dataWorkshop = dataWorkshop;
    }

    public String getACADEMIC_PROJECT() {
        return ACADEMIC_PROJECT;
    }

    public void setACADEMIC_PROJECT(String ACADEMIC_PROJECT) {
        this.ACADEMIC_PROJECT = ACADEMIC_PROJECT;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_list);
        this.setACADEMIC_PROJECT(getIntent().getStringExtra(StringName.ACADEMIC_PROJECT));

        TextView tv = (TextView) findViewById(R.id.textView_title);
        tv.setText("Final Year Project");
        this.setDataWorkshop(setDataWorkshopModel());

        ArrayAdapter<Semester> localArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, this.getDataWorkshop().getDataWorkshopModelList());
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
        if(position <= 3 )
        {
            Intent intent = new Intent(this, AcademicWorkshopDisplay.class);
            DataWorkshopModel dataWorkshopModel = this.getDataWorkshop().getDataWorkshopModelList().get(position);
            intent.putExtra(StringName.ACADEMIC_USEFUL_LINK, StringName.ACADEMIC_PROJECT);
            intent.putExtra(StringName.ACADEMIC_WORKSHOP_OBJECT, dataWorkshopModel);
            startActivity(intent);
        }
        if(position == 4)
        {
            Intent intent = new Intent(this, AcademicWorkshopLinks.class);
            DataWorkshopModel dataWorkshopModel = this.getDataWorkshop().getDataWorkshopModelList().get(position);
            intent.putExtra(StringName.ACADEMIC_WORKSHOP_OBJECT, dataWorkshopModel);
            intent.putExtra(StringName.ACADEMIC_USEFUL_LINK, StringName.ACADEMIC_PROJECT);
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

        return super.onOptionsItemSelected(paramMenuItem);
    }

    public DataWorkshop setDataWorkshopModel()
    {
        DataWorkshop dataWorkshop = new DataWorkshop();
        List<DataWorkshopModel> dataWorkshopModelList = new ArrayList<>() ;
        String tag ;
        String value ;
        DataWorkshopModel dataWorkshopModel ;
        ///Team Formation
        tag = getString(R.string.final_year_project_team_formation);
        value = getString(R.string.final_year_project_team_formation_text);
        dataWorkshopModel = new DataWorkshopModel(tag,value);
        dataWorkshopModelList.add(dataWorkshopModel);

        //Mentor Assignment
        tag = getString(R.string.final_year_project_mentor_assignment);
        value = getString(R.string.final_year_project_mentor_assignment_text);
        dataWorkshopModel = new DataWorkshopModel(tag,value);
        dataWorkshopModelList.add(dataWorkshopModel);

        //Project assignment
        tag = getString(R.string.final_year_project_project_assignment);
        value = getString(R.string.final_year_project_project_assignment_text);
        dataWorkshopModel = new DataWorkshopModel(tag,value);
        dataWorkshopModelList.add(dataWorkshopModel);

        //Project assignment
        tag = getString(R.string.final_year_project_project_inspection);
        value = getString(R.string.final_year_project_project_inspection_text);
        dataWorkshopModel = new DataWorkshopModel(tag,value);
        dataWorkshopModelList.add(dataWorkshopModel);

        ///Additional links for workshop
        tag = getString(R.string.final_year_project_project_links);
        value = getString(R.string.final_year_project_project_links);
        dataWorkshopModel = new DataWorkshopModel(tag,value);
        dataWorkshopModelList.add(dataWorkshopModel);

        dataWorkshop.setDataWorkshopModelList(dataWorkshopModelList);
        return dataWorkshop;
    }
}
