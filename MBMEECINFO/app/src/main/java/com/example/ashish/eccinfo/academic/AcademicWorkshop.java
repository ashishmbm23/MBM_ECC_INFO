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

public class AcademicWorkshop extends Activity {
    private  String ACADEMIC_WORKSHOP;
    private DataWorkshop dataWorkshop;

    public DataWorkshop getDataWorkshop() {
        return dataWorkshop;
    }

    public void setDataWorkshop(DataWorkshop dataWorkshop) {
        this.dataWorkshop = dataWorkshop;
    }

    public String getACADEMIC_WORKSHOP() {
        return ACADEMIC_WORKSHOP;
    }

    public void setACADEMIC_WORKSHOP(String ACADEMIC_WORKSHOP) {
        this.ACADEMIC_WORKSHOP = ACADEMIC_WORKSHOP;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_list);
        this.setACADEMIC_WORKSHOP(getIntent().getStringExtra(StringName.ACADEMIC_WORKSHOP));

        TextView tv = (TextView) findViewById(R.id.textView_title);
        tv.setText("Academic Workshop");

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
            intent.putExtra(StringName.ACADEMIC_USEFUL_LINK, StringName.ACADEMIC_WORKSHOP);
            intent.putExtra(StringName.ACADEMIC_WORKSHOP_OBJECT, dataWorkshopModel);
            startActivity(intent);
        }
        if(position == 3)
        {
            Intent intent = new Intent(this, AcademicWorkshopLinks.class);
            DataWorkshopModel dataWorkshopModel = this.getDataWorkshop().getDataWorkshopModelList().get(position);
            intent.putExtra(StringName.ACADEMIC_WORKSHOP_OBJECT, dataWorkshopModel);
            intent.putExtra(StringName.ACADEMIC_USEFUL_LINK, StringName.ACADEMIC_WORKSHOP);
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
        tag = getString(R.string.workShop_common_guidelines);
        value = getString(R.string.workShop_common_guidelines_text);
        dataWorkshopModel = new DataWorkshopModel(tag,value);
        dataWorkshopModelList.add(dataWorkshopModel);

        //Software
        tag = getString(R.string.workShop_software);
        value = getString(R.string.workShop_software_text);
        dataWorkshopModel = new DataWorkshopModel(tag,value);
        dataWorkshopModelList.add(dataWorkshopModel);

        //General Procedure
        tag = getString(R.string.workShop_general_procedure);
        value = getString(R.string.workShop_general_procedure_text);
        dataWorkshopModel = new DataWorkshopModel(tag,value);
        dataWorkshopModelList.add(dataWorkshopModel);

        ///Additional links for workshop
        tag = getString(R.string.workShop_links);
        value = getString(R.string.workShop_links);
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
