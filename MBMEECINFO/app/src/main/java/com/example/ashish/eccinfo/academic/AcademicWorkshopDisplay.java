package com.example.ashish.eccinfo.academic;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ashish.eccinfo.R;
import com.example.ashish.eccinfo.stringConstant.StringName;

/**
 * Created by Ashish on 8/20/2017.
 */

public class AcademicWorkshopDisplay extends Activity {
    private DataWorkshopModel dataWorkshopModel;

    public DataWorkshopModel getDataWorkshopModel() {
        return dataWorkshopModel;
    }

    public void setDataWorkshopModel(DataWorkshopModel dataWorkshopModel) {
        this.dataWorkshopModel = dataWorkshopModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        this.setDataWorkshopModel((DataWorkshopModel) getIntent().getSerializableExtra(StringName.ACADEMIC_WORKSHOP_OBJECT));

        TextView textViewTitle= (TextView) findViewById(R.id.textView_subjectName);
        textViewTitle.setText(this.getDataWorkshopModel().getWorkshopTitle());

        String str = getIntent().getStringExtra(StringName.ACADEMIC_USEFUL_LINK);
        if(str.equals(StringName.ACADEMIC_WORKSHOP))
        {

        }
        else if(str.equals(StringName.ACADEMIC_INTERNSHIP))
        {
            textViewTitle.setTextSize(20);
        }
        else if(str.equals(StringName.ACADEMIC_PROJECT))
        {

        }



        TextView textViewDetail= (TextView) findViewById(R.id.textView_show_sub);
        textViewDetail.setText(this.getDataWorkshopModel().getWorkshopDesc());

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

        return super.onOptionsItemSelected(paramMenuItem);
    }

}


