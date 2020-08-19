package com.example.ashish.eccinfo.contact;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.ashish.eccinfo.R;

/**
 * Created by Ashish on 7/23/2017.
 */

public class ContactUs extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }

    public void btnClickFB(View paramView)
    {
        String req= "https://www.facebook.com/ANeverTechnology?sw_fnr_id=1961646227&fnr_t=0";
        Uri webUri = Uri.parse(req);
        Intent intent = new Intent(Intent.ACTION_VIEW, webUri);
        startActivity(intent);
    }

    public void btnClickGmail(View paramView)
    {
        String req= "mailto:anevertechnologies@gmail.com?subject=MBM ECC Info";
        Uri webUri = Uri.parse(req);
        Intent intent = new Intent(Intent.ACTION_VIEW, webUri);
        startActivity(intent);
    }


}
