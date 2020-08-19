package com.example.ashish.eccinfo.links;

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
import com.example.ashish.eccinfo.academic.DataAcedemicDownloadModel;
import com.example.ashish.eccinfo.stringConstant.StringName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 7/23/2017.
 */

public class UsefulLinkMain extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_list);
        TextView tv = (TextView) findViewById(R.id.textView_title);
        tv.setText("Important Links");

        final List<DataAcedemicDownloadModel> links = getLinks();

        ArrayAdapter localArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, links);
        ListView localListView = (ListView) findViewById(R.id.listView_semester);
        localListView.setAdapter(localArrayAdapter);

        localListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataAcedemicDownloadModel downloadModel = links.get(position);
                displayDetail(downloadModel);
            }
        });

    }

    public void displayDetail(DataAcedemicDownloadModel downloadModel)
    {
        String req = downloadModel.getDownloadLink();
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

    public List<DataAcedemicDownloadModel> getLinks()
    {
        List<DataAcedemicDownloadModel> links = new ArrayList<>();
        links.add(new DataAcedemicDownloadModel("JNVU Official Home Page", StringName.USEFUL_LINKS_JNVU_HOME));
        links.add(new DataAcedemicDownloadModel("JNVU Online Home Page", StringName.USEFUL_LINKS_JNVU_ONLINE));
        links.add(new DataAcedemicDownloadModel("JNVU Online Portal", StringName.USEFUL_LINKS_JNVU_ONLINE_PORTAL));
        links.add(new DataAcedemicDownloadModel("JNVU Registration Portal", StringName.USEFUL_LINKS_JNVU_REGISTRATION_PORTAL));
        links.add(new DataAcedemicDownloadModel("JNVU Candidate Login Portal", StringName.USEFUL_LINKS_JNVU_REGISTRATION_LOGIN_PORTAL));
        links.add(new DataAcedemicDownloadModel("JNVU Examination Portal", StringName.USEFUL_LINKS_JNVU_EXAM_PORTAL));
        links.add(new DataAcedemicDownloadModel("JNVU Timetable Home Page", StringName.USEFUL_LINKS_JNVU_ONLINE_TIMETABLE));
        links.add(new DataAcedemicDownloadModel("JNVU Admit Card Home Page", StringName.USEFUL_LINKS_JNVU_ONLINE_ADMIT_HOME));
        links.add(new DataAcedemicDownloadModel("JNVU Admit Card Download Portal", StringName.USEFUL_LINKS_JNVU_ONLINE_ADMIT_DOWNLOAD));
        links.add(new DataAcedemicDownloadModel("JNVU Result Home Page", StringName.USEFUL_LINKS_JNVU_RESULT_HOME));
        links.add(new DataAcedemicDownloadModel("JNVU Semester Result Home Page", StringName.USEFUL_LINKS_JNVU_RESULT_SEMESTER));
        links.add(new DataAcedemicDownloadModel("JNVU Re-evaluation Result Home Page", StringName.USEFUL_LINKS_JNVU_RESULT_REVAL));
        links.add(new DataAcedemicDownloadModel("MBM Official Web Site", StringName.USEFUL_LINKS_MBM_HOME));
        links.add(new DataAcedemicDownloadModel("ECC Syllabus Download (JNVU OFficial Website)", StringName.USEFUL_LINKS_ECC_SYLLABUS));
        return  links;
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
