package com.kumar.sooraj.wastetracker;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Sooraj on 1/10/2017.
 */

public class alarm_page extends AppCompatActivity {
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackerfront);
        Toolbar toolbar = (Toolbar)findViewById(R.id.alarm_page_toolbar);
        setSupportActionBar(toolbar);
        Bundle data = getIntent().getExtras();


    }
}
