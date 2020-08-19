package com.example.ashish.eccinfo.exampattern;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashish.eccinfo.R;
import com.example.ashish.eccinfo.stringConstant.StringName;

import java.io.InputStream;

/**
 * Created by Ashish on 8/20/2017.
 */

public class ExamPatternShowImage extends Activity {
    private  String SEMESTER_ID;
    private   String SEMESTER_NAME;

    public String getSEMESTER_ID() {
        return SEMESTER_ID;
    }

    public void setSEMESTER_ID(String SEMESTER_ID) {
        this.SEMESTER_ID = SEMESTER_ID;
    }

    public String getSEMESTER_NAME() {
        return SEMESTER_NAME;
    }

    public void setSEMESTER_NAME(String SEMESTER_NAME) {
        this.SEMESTER_NAME = SEMESTER_NAME;
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_exam_pattern_image);
        // SEMESTER_ID = getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_ID);
        this.setSEMESTER_ID(getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_ID));
        this.setSEMESTER_NAME(getIntent().getStringExtra(StringName.EXAM_PATTERN_SEMESTER_NAME));

        TextView title = (TextView) findViewById(R.id.exam_pattern_image_title);
        title.setText(this.getSEMESTER_NAME() + " Exam pattern");

        String image_name = "sem_" + this.getSEMESTER_ID() + "_exam_pattern.PNG";
        ImageView imageView = (ImageView) findViewById(R.id.exam_pattern_image);
        try
        {
            InputStream stream = getAssets().open(image_name);
            Drawable drawable = Drawable.createFromStream(stream, null);
            imageView.setImageDrawable(drawable);
        }
        catch (Exception e)
        {
            Log.e("EXAM_PATTERN_IMAGE", e.getMessage());
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == StringName.EXAM_PATTERN_DISPLAY_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                String msg = data.getStringExtra("resultMessage");
                TextView tv = (TextView) findViewById(R.id.textView_title);
                tv.setText(msg);
                //Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            }
        }
    }


}
