package com.kumar.sooraj.wastetracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

/**
 * Created by Sooraj on 12/26/2016.
 */

public class editpage extends AppCompatActivity implements editsection.EditSectionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.v("got to before set view", "hh");
        setContentView(R.layout.editpage);
        Log.v("got here", "woo hoo");
        Toolbar editpagetoolbar = (Toolbar)findViewById(R.id.edit_page_toolbar);
        setSupportActionBar(editpagetoolbar);
    }

    @Override
    public void generatePrev(String title, String time, String month, String day, String year) {
       // preview_sec prev = (preview_sec)getFragmentManager().findFragmentById(R.id.fragment2);
        //prev.generatePrevText(title, time,  month, day, year);
    }
}
