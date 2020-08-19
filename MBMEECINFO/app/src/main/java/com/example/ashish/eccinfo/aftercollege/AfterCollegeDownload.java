package com.example.ashish.eccinfo.aftercollege;

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

/**
 * Created by Ashish on 8/22/2017.
 */

public class AfterCollegeDownload extends Activity{
    PostCollege postCollege = new PostCollege();

    public PostCollege getPostCollege() {
        return postCollege;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_list);
        this.setPostCollege((PostCollege) getIntent().getSerializableExtra(StringName.MAIN_AFTER_COLLEGE_OBJECT));
        String display_id = getIntent().getStringExtra(StringName.MAIN_AFTER_COLLEGE_OBJECT_ID);

        TextView tv = (TextView) findViewById(R.id.textView_title);
        tv.setText(this.getPostCollege().getPostCollegeName());
        ArrayAdapter localArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.getPostCollege().getDownloadLinks());
        ListView localListView = (ListView) findViewById(R.id.listView_semester);
        localListView.setAdapter(localArrayAdapter);

        localListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                displayLink(postCollege.getDownloadLinks().get(position));
            }
        });
    }

    public void setPostCollege(PostCollege postCollege) {
        this.postCollege = postCollege;
    }

    public void displayLink(DataAcedemicDownloadModel dataAcedemicDownloadModel)
    {
        String req = dataAcedemicDownloadModel.getDownloadLink();
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
