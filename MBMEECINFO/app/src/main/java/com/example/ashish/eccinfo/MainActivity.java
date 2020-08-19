package com.example.ashish.eccinfo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.example.ashish.eccinfo.academic.AcademicMain;
import com.example.ashish.eccinfo.aftercollege.AfterCollegeActivity;
import com.example.ashish.eccinfo.contact.ContactUs;
import com.example.ashish.eccinfo.links.UsefulLinkMain;
import com.example.ashish.eccinfo.placementPoint.PlacementMain;

import com.example.ashish.eccinfo.exampattern.ExamPatternShow;
import com.example.ashish.eccinfo.stringConstant.StringName;

public class MainActivity extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setContentView(R.layout.activity_main);

      ///  getSupportActionBar().setHomeButtonEnabled(true);
        return super.onCreateOptionsMenu(menu);

    }

    public static final String ACADEMIC = "Academic";
    public static final String EXAM = "exam";
    public static final String POST_COLLEGE = "After College";
    public static final String SEMESTER = "Semester";
    public static final String USEFUL_LINKS = "Useful Links";

   public void btnClickHandleExamPattern(View paramView)
    {
        //paramView
          Intent intent = new Intent(this, ExamPatternShow.class);
            intent.putExtra("exam", "exam");
            startActivity(intent);
    }

    public void btnClickHandlerAcademic(View paramView)
    {
        Intent inten = new Intent(this, AcademicMain.class);
        inten.putExtra(StringName.MAIN_ACADEMIC, StringName.MAIN_ACADEMIC);
        startActivity(inten);
    }

    public void btnClickHandlerAfterCollege(View paramView)
    {
        Intent intent = new Intent(this, AfterCollegeActivity.class);
        intent.putExtra(StringName.MAIN_MAIN, StringName.MAIN_AFTER_COLLEGE);
        startActivity(intent);
    }

    public void btnClickHandlerContactUs(View paramView)
    {
        startActivity(new Intent(this, ContactUs.class));
    }

    public void btnClickHandlerPlacementCorner(View paramView)
    {
        Intent intent = new Intent(this, PlacementMain.class);
        intent.putExtra(StringName.MAIN_MAIN, StringName.MAIN_PLACEMENT);
        startActivity(intent);
    }

    public void btnClickHandlerSemester(View paramView)
    {
        Intent intent = new Intent(this, SemesterActivity.class);
        intent.putExtra("Semester", "Semester");
        startActivity(intent);
    }

    public void btnClickHandlerUsefulLinks(View paramView)
    {
        Intent intent = new Intent(this, UsefulLinkMain.class);
        intent.putExtra("Useful Links", "Useful Links");
        startActivity(intent);
    }

   protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_main);
        /*paramBundle = getWindow().findViewById();
        if (paramBundle != null)
        {
            paramBundle = paramBundle.getParent();
            if ((paramBundle != null) && ((paramBundle instanceof View)))
                ((View)paramBundle).setBackgroundColor(Color.rgb(136, 51, 51));
        }*/
    }



    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        if (paramMenuItem.getItemId() == R.id.action_settings)
        {
            return true;
        }

        else if(paramMenuItem.getItemId() == android.R.id.home)
        {
            Uri webUri = Uri.parse("https://www.google.com");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
            startActivity(webIntent);
            finish();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }
}
