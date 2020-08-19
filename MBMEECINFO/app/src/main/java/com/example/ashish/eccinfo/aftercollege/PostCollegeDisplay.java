package com.example.ashish.eccinfo.aftercollege;

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

/**
 * Created by Ashish on 7/23/2017.
 */

public class PostCollegeDisplay extends Activity {

    PostCollege postCollege = new PostCollege();

    public PostCollege getPostCollege() {
        return postCollege;
    }

    public void setPostCollege(PostCollege postCollege) {
        this.postCollege = postCollege;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_list);

        this.setPostCollege((PostCollege) getIntent().getSerializableExtra(StringName.MAIN_AFTER_COLLEGE_OBJECT));

        TextView tv = (TextView) findViewById(R.id.textView_title);
        tv.setText(this.getPostCollege().getPostCollegeName());

        ArrayAdapter<Semester> localArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, this.getPostCollege().getMenuList());
        ListView localListView = (ListView)findViewById(R.id.listView_semester);
        localListView.setAdapter(localArrayAdapter);

        localListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                displayDetail(position,postCollege);
            }
        });

    }
public void displayDetail(int position, PostCollege college)
{
    if(position <= 1)
    {
        Intent intent = new Intent(this, AfterCollegeActivityDisplay.class);
        intent.putExtra(StringName.MAIN_AFTER_COLLEGE_OBJECT_ID, position+"");
        intent.putExtra(StringName.MAIN_AFTER_COLLEGE_OBJECT,college);
        startActivity(intent);
    }
    if(position == 2)
    {
        Intent intent = new Intent(this, AfterCollegeDownload.class);
        intent.putExtra(StringName.MAIN_AFTER_COLLEGE_OBJECT_ID, position+"");
        intent.putExtra(StringName.MAIN_AFTER_COLLEGE_OBJECT,college);
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



