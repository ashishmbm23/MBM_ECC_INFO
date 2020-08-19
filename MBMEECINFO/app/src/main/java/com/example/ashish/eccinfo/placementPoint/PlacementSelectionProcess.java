package com.example.ashish.eccinfo.placementPoint;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class PlacementSelectionProcess extends Activity {

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
        String display_id = getIntent().getStringExtra(StringName.PLACEMENT_COMPANY_DISPLAY_POSITION);
        TextView tv = (TextView) findViewById(R.id.textView_title);
        if(display_id.trim().equals("1")) {
            tv.setText("Selection Process");

            ArrayAdapter localArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.getPlacementCompany().getCompanyPatternList());
            ListView localListView = (ListView) findViewById(R.id.listView_semester);
            localListView.setAdapter(localArrayAdapter);

            localListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    displayDetail(position, placementCompany.getCompanyPatternList().get(position));
                }
            });
        }
        if(display_id.trim().equals("4")) {
            tv.setText("External Links");
            ArrayAdapter localArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.getPlacementCompany().getCompanyLinkList());
            ListView localListView = (ListView) findViewById(R.id.listView_semester);
            localListView.setAdapter(localArrayAdapter);

            localListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    displayLink(placementCompany.getCompanyLinkList().get(position));
                }
            });
        }


    }

    public void displayLink(PlacementCompanyLink placementCompanyLink)
    {
        String req = placementCompanyLink.getLinkDesc().trim();
        if(req.contains(".pdf"))
        {
            DownloadManager downloadManager= (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri=Uri.parse(req);
            DownloadManager.Request request=new DownloadManager.Request(uri);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            Long reference=downloadManager.enqueue(request);

        }
        else
        {
            Uri webUri = Uri.parse(req);
            Intent intent = new Intent(Intent.ACTION_VIEW, webUri);
            startActivity(intent);
        }

    }

    public void displayDetail(int position, PlacementCompanyPattern placementCompanyPattern)
    {
            Intent intent = new Intent(this, PlacementSelectionProcessDisplay.class);
            intent.putExtra(StringName.PLACEMENT_COMPANY_LINK_OBJECT, placementCompanyPattern);
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
