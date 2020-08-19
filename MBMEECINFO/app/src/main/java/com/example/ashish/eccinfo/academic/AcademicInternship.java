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

public class AcademicInternship extends Activity {

    private  String ACADEMIC_INTERNSHIP;
    private DataWorkshop dataWorkshop;

    public String getACADEMIC_INTERNSHIP() {
        return ACADEMIC_INTERNSHIP;
    }

    public void setACADEMIC_INTERNSHIP(String ACADEMIC_INTERNSHIP) {
        this.ACADEMIC_INTERNSHIP = ACADEMIC_INTERNSHIP;
    }

    public DataWorkshop getDataWorkshop() {
        return dataWorkshop;
    }

    public void setDataWorkshop(DataWorkshop dataWorkshop) {
        this.dataWorkshop = dataWorkshop;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_list);
        this.setACADEMIC_INTERNSHIP(getIntent().getStringExtra(StringName.ACADEMIC_INTERNSHIP));

        TextView tv = (TextView) findViewById(R.id.textView_title);
        tv.setText("Academic Internship / Training");
        this.setDataWorkshop(setDataWorkshopModel());
        // DataWorkshopModel dataWorkshopModel = new DataWorkshopModel(getString(R.string.));

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
        if(position <= 2 )
        {
            Intent intent = new Intent(this, AcademicWorkshopDisplay.class);
            DataWorkshopModel dataWorkshopModel = this.getDataWorkshop().getDataWorkshopModelList().get(position);
            intent.putExtra(StringName.ACADEMIC_USEFUL_LINK, StringName.ACADEMIC_INTERNSHIP);
            intent.putExtra(StringName.ACADEMIC_WORKSHOP_OBJECT, dataWorkshopModel);
            startActivity(intent);
        }
        if(position == 3)
        {
            Intent intent = new Intent(this, AcademicWorkshopLinks.class);
            DataWorkshopModel dataWorkshopModel = this.getDataWorkshop().getDataWorkshopModelList().get(position);
            intent.putExtra(StringName.ACADEMIC_WORKSHOP_OBJECT, dataWorkshopModel);
            intent.putExtra(StringName.ACADEMIC_USEFUL_LINK, StringName.ACADEMIC_INTERNSHIP);
            startActivity(intent);
        }

    }


    public DataWorkshop setDataWorkshopModel()
    {
        DataWorkshop dataWorkshop = new DataWorkshop();
        List<DataWorkshopModel> dataWorkshopModelList = new ArrayList<>() ;
        String tag ;
        String value ;
        DataWorkshopModel dataWorkshopModel ;
        ///Common guidelines
        tag = getString(R.string.internship_common_guidelines);
        value = getString(R.string.internship_common_guidelines_text);
        dataWorkshopModel = new DataWorkshopModel(tag,value);
        dataWorkshopModelList.add(dataWorkshopModel);

        //Documents
        tag = getString(R.string.internship_document);
        value = getString(R.string.internship_document_text);
        dataWorkshopModel = new DataWorkshopModel(tag,value);
        dataWorkshopModelList.add(dataWorkshopModel);

        //General Procedure
        tag = getString(R.string.internship_training_viva);
        value = getString(R.string.internship_training_viva_text);
        dataWorkshopModel = new DataWorkshopModel(tag,value);
        dataWorkshopModelList.add(dataWorkshopModel);

        ///Additional links for workshop
        tag = getString(R.string.internship_training_links);
        value = getString(R.string.internship_training_links);
        dataWorkshopModel = new DataWorkshopModel(tag,value);
        dataWorkshopModelList.add(dataWorkshopModel);

        dataWorkshop.setDataWorkshopModelList(dataWorkshopModelList);
        return dataWorkshop;
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

}
