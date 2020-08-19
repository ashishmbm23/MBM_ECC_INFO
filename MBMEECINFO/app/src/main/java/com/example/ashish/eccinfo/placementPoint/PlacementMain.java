package com.example.ashish.eccinfo.placementPoint;

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

public class PlacementMain extends Activity {
    private String MAIN_MAIN;
    private List<PlacementCompany> placementCompanyList = new ArrayList<>();

    public List<PlacementCompany> getPlacementCompanyList() {
        return placementCompanyList;
    }

    public void setPlacementCompanyList(List<PlacementCompany> placementCompanyList) {
        this.placementCompanyList = placementCompanyList;
    }

    public String getMAIN_MAIN() {
        return MAIN_MAIN;
    }

    public void setMAIN_MAIN(String MAIN_MAIN) {
        this.MAIN_MAIN = MAIN_MAIN;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_list);
        this.setMAIN_MAIN(getIntent().getStringExtra(StringName.MAIN_MAIN));

        TextView tv = (TextView) findViewById(R.id.textView_title);
        tv.setText(this.getMAIN_MAIN());

        this.setPlacementCompanyList(new PlacementJDOMParcer().parseXML(this.getApplicationContext()));
        ArrayAdapter<Semester> localArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, this.getPlacementCompanyList());
        ListView localListView = (ListView)findViewById(R.id.listView_semester);
        localListView.setAdapter(localArrayAdapter);

        localListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PlacementCompany placementCompany = placementCompanyList.get(position);
                displayDetail(placementCompany);
            }
        });

    }

    public void displayDetail(PlacementCompany placementCompany)
    {
        Intent intent = new Intent(this, PlacementCompanyDisplay.class);
        intent.putExtra(StringName.PLACEMENT_COMPANY_LINK_OBJECT, placementCompany);
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
