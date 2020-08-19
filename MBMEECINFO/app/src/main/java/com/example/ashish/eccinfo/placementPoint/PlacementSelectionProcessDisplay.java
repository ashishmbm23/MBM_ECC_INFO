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

public class PlacementSelectionProcessDisplay extends Activity {
    private PlacementCompanyPattern placementCompanyPattern;

    public PlacementCompanyPattern getPlacementCompanyPattern() {
        return placementCompanyPattern;
    }

    public void setPlacementCompanyPattern(PlacementCompanyPattern placementCompanyPattern) {
        this.placementCompanyPattern = placementCompanyPattern;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        this.setPlacementCompanyPattern((PlacementCompanyPattern) getIntent().getSerializableExtra(StringName.PLACEMENT_COMPANY_LINK_OBJECT));

        TextView textViewTitle= (TextView) findViewById(R.id.textView_subjectName);
        textViewTitle.setText(this.getPlacementCompanyPattern().getRoundName());

        TextView textViewDetail= (TextView) findViewById(R.id.textView_show_sub);
        textViewDetail.setText(this.getPlacementCompanyPattern().getRoundDetail());
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
