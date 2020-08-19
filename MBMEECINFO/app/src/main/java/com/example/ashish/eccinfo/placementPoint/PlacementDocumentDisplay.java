package com.example.ashish.eccinfo.placementPoint;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ashish.eccinfo.R;
import com.example.ashish.eccinfo.stringConstant.StringName;

/**
 * Created by Ashish on 8/21/2017.
 */

public class PlacementDocumentDisplay extends Activity {

    private PlacementCompany placementCompany = new PlacementCompany();

    public PlacementCompany getPlacementCompany() {
        return placementCompany;
    }

    public void setPlacementCompany(PlacementCompany placementCompany) {
        this.placementCompany = placementCompany;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        this.setPlacementCompany((PlacementCompany) getIntent().getSerializableExtra(StringName.PLACEMENT_COMPANY_LINK_OBJECT));
        String display_id = getIntent().getStringExtra(StringName.PLACEMENT_COMPANY_DISPLAY_POSITION);
        TextView textViewTitle= (TextView) findViewById(R.id.textView_subjectName);
        TextView textViewDetail= (TextView) findViewById(R.id.textView_show_sub);

        if(display_id.trim().equals("0"))
        {
            textViewTitle.setText("Informal details");
            textViewDetail.setText(this.getPlacementCompany().getCompanyDetail());
        }
        else if(display_id.trim().equals("2"))
        {
            textViewTitle.setText("Important Documents");
            textViewDetail.setText(this.getPlacementCompany().getCompanyDocument());
        }
        else if(display_id.trim().equals("3"))
        {
            textViewTitle.setText("Eligibility Criteria");
            textViewDetail.setText(this.getPlacementCompany().getCompanyEligibilityCriteria());
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
