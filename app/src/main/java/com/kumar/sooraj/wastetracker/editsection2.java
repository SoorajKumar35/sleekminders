package com.kumar.sooraj.wastetracker;

import android.app.Activity;
import com.kumar.sooraj.wastetracker.R.drawable;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.kumar.sooraj.wastetracker.R.id.contentPanel;
import static com.kumar.sooraj.wastetracker.R.id.edit_sec_toolbar;
import static com.kumar.sooraj.wastetracker.R.id.icon;
import static com.kumar.sooraj.wastetracker.R.id.new_color_spin;

/**
 * Created by Sooraj on 1/5/2017.
 */

public class editsection2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static EditText new_ed_title;
    private static EditText new_ed_addr;
    private static Spinner new_day_spin;
    private static Spinner new_month_spin;
    private static Spinner new_year_spin;
    private static Spinner new_hour_spin;
    private static Spinner new_min_spin;
    private static Spinner new_color_spin;
    private static Spinner new_spin_icon;
    private static Button b_create;

    Context context = this;
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("got before inflation", "");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_edit_page);
        Toolbar edit_sec_toolbar = (Toolbar)findViewById(R.id.edit_sec_toolbar);
        edit_sec_toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(edit_sec_toolbar);

        Log.v("got after the inflation", "");
        new_ed_title = (EditText)findViewById(R.id.new_ed_title);
        new_ed_addr = (EditText)findViewById(R.id.new_ed_addr);

        new_day_spin = (Spinner)findViewById(R.id.new_day_spin);
        new_month_spin = (Spinner)findViewById(R.id.new_month_spin);
        new_year_spin = (Spinner)findViewById(R.id.new_year_spin);
        new_hour_spin = (Spinner)findViewById(R.id.new_hour_spin);
        new_min_spin = (Spinner)findViewById(R.id.new_min_spin);
        new_color_spin = (Spinner)findViewById(R.id.new_color_spin);

        b_create = (Button)findViewById(R.id.b_create);

        new_day_spin.setOnItemSelectedListener(this);
        new_month_spin.setOnItemSelectedListener(this);
        new_year_spin.setOnItemSelectedListener(this);
        new_hour_spin.setOnItemSelectedListener(this);
        new_min_spin.setOnItemSelectedListener(this);


        Log.v("got before assignments", "");
        Calendar c = Calendar.getInstance();
        int orig_year = c.get(Calendar.YEAR);
        ArrayList<String> years = new ArrayList<String>();
        for(int i = 0; i < 10; i++)
        {

            String year = "" + String.valueOf(orig_year + i);
            years.add(year);
        }

        List<String> days = new ArrayList<String>();
        for(int i = 1; i < 32  ; i++)
        {
            days.add("" + i);
        }

        ArrayList<String> months = new ArrayList<String>();
        for(int i = 1; i < 13; i++)
        {
            months.add("" + i);
        }

        ArrayList<String> hours = new ArrayList<String>();
        for(int i = 1; i < 24; i++)
        {
            hours.add("" + i);
        }

        ArrayList<String> min = new ArrayList<String>();
        for(int i = 0; i < 59;i++){
            min.add("" + i);
        }

        /*The color and icon image arrays here */


        Integer[] colors = {R.drawable.blue,drawable.red,drawable.green,drawable.orange};
        image_adapter adapter = new image_adapter(context, colors  );

        intimgpair red = new intimgpair(drawable.red,"red");
        intimgpair blue = new intimgpair(drawable.blue, "blue");
        intimgpair green = new intimgpair(drawable.green, "green");
        intimgpair orange = new intimgpair(drawable.orange, "orange");
        intimgpair white = new intimgpair(drawable.white, "white");
        intimgpair yellow = new intimgpair(drawable.yellow, "yellow");

        final intimgpair[] pairs = {red, blue, green, orange, white, yellow};
        image_adapter_2 new_adapter = new image_adapter_2(context, pairs);
        if(new_adapter == null)
        {
            Log.v("this adap is null", "");
        }

        final Integer[] colors_3 = {
          R.color.blue, R.color.red, R.color.green, R.color.white, R.color.orange, R.color.yellow
        };
        image_adapter_3 new_adapter_3 = new image_adapter_3(context,colors_3);
       // new_color_spin.setAdapter(new_adapter_3);
        new_color_spin.setAdapter((new_adapter));

       // new_color_spin.setAdapter(adapter);

        intimgpair study = new intimgpair(drawable.study2,"study");
        intimgpair meeting = new intimgpair(drawable.meeting2, "meeting");
        intimgpair classy = new intimgpair(drawable.class2, "class");
        final intimgpair[] icons = {study, meeting, classy};
        image_adapter_2 icon_adapter = new image_adapter_2(context, icons);

        ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);
        ArrayAdapter<String> yearsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);
        ArrayAdapter<String> monthsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, months);
        ArrayAdapter<String> hoursAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hours);
        ArrayAdapter<String> minsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, min);

        new_day_spin.setAdapter(dayAdapter);
        new_year_spin.setAdapter(yearsAdapter);
        new_hour_spin.setAdapter(hoursAdapter);
        new_month_spin.setAdapter(monthsAdapter);
        new_min_spin.setAdapter(minsAdapter);
        Log.v("got before button", "");

        b_create.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                        Intent i = new Intent(editsection2.this, trackerfront.class);
                        i.putExtra("title", new_ed_title.getText().toString()+"");
                        i.putExtra("address", new_ed_addr.getText().toString());
                        i.putExtra("day", new_day_spin.getSelectedItem().toString());
                        i.putExtra("month", new_month_spin.getSelectedItem().toString());
                        i.putExtra("year", new_year_spin.getSelectedItem().toString());
                        i.putExtra("min" , new_min_spin.getSelectedItem().toString());
                        i.putExtra("hour", new_hour_spin.getSelectedItem().toString());
                        i.putExtra("color", pairs[new_color_spin.getSelectedItemPosition()].identifier);
                        Log.v(pairs[new_color_spin.getSelectedItemPosition()].identifier,"");
                        i.putExtra("pos", -1);
                        startActivity(i);

                    }
                }
        );
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}

class intimgpair{
    intimgpair(int drawableID, String identifier)
    {
        this.drawableID = drawableID;
        this.identifier = identifier;
    }
    int drawableID;
    String identifier;
}
