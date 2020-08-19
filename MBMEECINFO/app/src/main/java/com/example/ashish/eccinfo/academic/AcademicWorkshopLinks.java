package com.example.ashish.eccinfo.academic;

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
import com.example.ashish.eccinfo.Semester;
import com.example.ashish.eccinfo.stringConstant.StringName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 8/20/2017.
 */

public class AcademicWorkshopLinks extends Activity {

    private List<DataAcedemicDownloadModel> dowloadList;

    public List<DataAcedemicDownloadModel> getDowloadList() {
        return dowloadList;
    }

    public void setDowloadList(List<DataAcedemicDownloadModel> dowloadList) {
        this.dowloadList = dowloadList;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_list);
        //this.setAcademicDownload(getIntent().getStringExtra(StringName.ACADEMIC_DOWNLOAD));
        TextView tv = (TextView) findViewById(R.id.textView_title);

        String str = getIntent().getStringExtra(StringName.ACADEMIC_USEFUL_LINK);
        if(str.equals(StringName.ACADEMIC_WORKSHOP))
        {
            tv.setText("Workshop Useful Links");
            this.setDowloadList(DataAcademicWorkshopLink.getDowloadList());
        }
        else if(str.equals(StringName.ACADEMIC_INTERNSHIP))
        {
            tv.setText("Internship Useful Links");
            this.setDowloadList(DataAcademicInternshipLinks.getDowloadList());
        }
        else if(str.equals(StringName.ACADEMIC_PROJECT))
        {
            tv.setText("Final Year Project Useful Links");
            DataAcedemicDownloadModel DataAcedemicDownloadModel = new DataAcedemicDownloadModel("Final Year Sample Project Report",StringName.ACADEMIC_PROJECT_REPORT);
            dowloadList = new ArrayList<>();
            dowloadList.add(DataAcedemicDownloadModel);
            this.setDowloadList(dowloadList);
        }




        ArrayAdapter<Semester> localArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, this.getDowloadList());
        ListView localListView = (ListView)findViewById(R.id.listView_semester);
        localListView.setAdapter(localArrayAdapter);

        localListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataAcedemicDownloadModel DataAcedemicDownloadModel = dowloadList.get(position);
                String req = DataAcedemicDownloadModel.getDownloadLink();
                if(req.contains(".pdf"))
                {
                    DownloadManager downloadManager= (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri=Uri.parse(DataAcedemicDownloadModel.getDownloadLink());
                    DownloadManager.Request request=new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference=downloadManager.enqueue(request);

                }
                else
                {
                    Uri webUri = Uri.parse(DataAcedemicDownloadModel.getDownloadLink());
                    Intent intent = new Intent(Intent.ACTION_VIEW, webUri);
                    startActivity(intent);
                }




            }
        });
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
