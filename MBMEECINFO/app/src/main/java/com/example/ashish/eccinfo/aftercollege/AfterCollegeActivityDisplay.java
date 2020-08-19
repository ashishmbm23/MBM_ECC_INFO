package com.example.ashish.eccinfo.aftercollege;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ashish.eccinfo.R;
import com.example.ashish.eccinfo.stringConstant.StringName;

/**
 * Created by Ashish on 8/22/2017.
 */

public class AfterCollegeActivityDisplay extends Activity {
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
        setContentView(R.layout.activity_subject);
        this.setPostCollege((PostCollege) getIntent().getSerializableExtra(StringName.MAIN_AFTER_COLLEGE_OBJECT));
        String display_id = getIntent().getStringExtra(StringName.MAIN_AFTER_COLLEGE_OBJECT_ID);
        TextView textViewTitle= (TextView) findViewById(R.id.textView_subjectName);
        TextView textViewDetail= (TextView) findViewById(R.id.textView_show_sub);
        if(display_id.trim().equals("0"))
        {
            textViewTitle.setText(this.getPostCollege().getPostCollegeName());
            textViewDetail.setText(this.getPostCollege().getDocument());
        }
        else if(display_id.trim().equals("1"))
        {
            textViewTitle.setText(this.getPostCollege().getPostCollegeName());
            textViewDetail.setText(this.getPostCollege().getProcedure());
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
