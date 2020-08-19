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
import com.example.ashish.eccinfo.stringConstant.StringName;

/**
 * Created by Ashish on 8/21/2017.
 */

public class PlacementCompanyDisplay extends Activity {
    private PlacementCompany placementCompany;

    public PlacementCompany getPlacementCompany() {
        return placementCompany;
    }

    public void setPlacementCompany(PlacementCompany placementCompany) {
        this.placementCompany = placementCompany;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_list);
        this.setPlacementCompany((PlacementCompany) getIntent().getSerializableExtra(StringName.PLACEMENT_COMPANY_LINK_OBJECT));

        TextView tv = (TextView) findViewById(R.id.textView_title);
        tv.setText(this.getPlacementCompany().getCompanyName());

        ArrayAdapter localArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, new PlacementCompany().getListDetails());
        ListView localListView = (ListView)findViewById(R.id.listView_semester);
        localListView.setAdapter(localArrayAdapter);

        localListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                displayDetail(position, placementCompany);
            }
        });
    }

    public void displayDetail(int position, PlacementCompany placementCompany)
    {
        if(position == 1 || position == 4)
        {
            Intent intent = new Intent(this, PlacementSelectionProcess.class);
            intent.putExtra(StringName.PLACEMENT_COMPANY_DISPLAY_POSITION, position+"");
            intent.putExtra(StringName.PLACEMENT_COMPANY_LINK_OBJECT, placementCompany);
            startActivity(intent);

        }
        else if(position == 0 |position == 2 || position == 3 )
        {
            Intent intent = new Intent(this, PlacementDocumentDisplay.class);
            intent.putExtra(StringName.PLACEMENT_COMPANY_LINK_OBJECT, placementCompany);
            intent.putExtra(StringName.PLACEMENT_COMPANY_DISPLAY_POSITION, position+"");
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
}
