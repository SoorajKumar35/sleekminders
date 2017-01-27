package com.kumar.sooraj.wastetracker;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;


/**
 * Created by Sooraj on 12/26/2016.
 */
public class trackerfront extends AppCompatActivity {
    static ArrayList<reminder> reminders = new ArrayList<reminder>();
    custom_adapter adapter = new custom_adapter(this,reminders);
    AlarmManager alarmManager;
    PendingIntent pending_intent;
    TimePicker alarmTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackerfront);
        Toolbar trackerfronttoolbar = (Toolbar)findViewById(R.id.front_tracker_toolbar);
        setSupportActionBar(trackerfronttoolbar);
        //Get Listview and setup the list
        ListView listy = (ListView) findViewById(R.id.front_list);
        listy.setAdapter(adapter);
        listy.setPadding(5,10,5,0);
        //Get data from editpage about reminders
        Bundle remindaerdata = getIntent().getExtras();

        if(remindaerdata == null) {
            return;
        }

        String title, address, day, month, year, min, hour, color;
        title = address = day = month = year = min = hour = color = null;
        int new_req = -1;
        int pos = remindaerdata.getInt("pos");
        if(pos == -1) {
            reminder new_rem = new reminder();


            new_rem.title = remindaerdata.getString("title");
            title = remindaerdata.getString("title");
            new_rem.address = remindaerdata.getString("address");
            address = remindaerdata.getString("address");
            new_rem.day = remindaerdata.getString("day");
            day = remindaerdata.getString("day");
            new_rem.month = remindaerdata.getString("month");
            month = remindaerdata.getString("month");
            new_rem.year = remindaerdata.getString("year");
            year = remindaerdata.getString("year");
            new_rem.min = remindaerdata.getString("min");
            min = remindaerdata.getString("min");
            new_rem.hour = remindaerdata.getString("hour");
            hour = remindaerdata.getString("hour");
            new_rem.color = remindaerdata.getString("color");
            color = remindaerdata.getString("color");
            new_rem.icon_ID = remindaerdata.getInt("icon");
            Log.v(day + " " + month + " " + year + " " + hour + " " + min, "");


            reminders.add(new_rem);
            adapter.notifyDataSetChanged();
            new_req = reminders.size();
        }
        else if(pos != -1)
        {
            Log.v("got before removal", "");
            reminders.remove(pos-1);
            adapter.notifyDataSetChanged();
            return;
        }

        /*Set the alarm off*/

        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        final Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));
        calendar.set(Calendar.YEAR, Integer.valueOf(year));
        calendar.set(Calendar.MONTH, Integer.valueOf(month) - 1);
        calendar.set(Calendar.MINUTE, Integer.valueOf(min));
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        if(Integer.valueOf(hour) >= 12)
        {
            int new_time = Integer.valueOf(hour) - 12;
            hour = String.valueOf(new_time);
            calendar.set(Calendar.HOUR, Integer.valueOf(hour));
            calendar.set(Calendar.AM_PM, Calendar.PM);

        }
        else
        {
            calendar.set(Calendar.HOUR, Integer.valueOf(hour));
            calendar.set(Calendar.AM_PM, Calendar.AM);
        }

        int minute_int = Integer.valueOf(min);
        int hour_int = Integer.valueOf(hour);

        final Intent in = new Intent(this, AlarmReceiver.class);
        in.putExtra("pos",new_req);
        pending_intent = PendingIntent.getBroadcast(this, new_req,in, PendingIntent.FLAG_UPDATE_CURRENT);
        String TAG = "" + calendar.getTimeZone();
        String TAGthesecond = "" + calendar.getTime();
        Log.v(TAG, "blue balad");
        Log.v(TAGthesecond, "blasdf;");
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbarmenu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.action_favorite:
                Log.v("got before intent make","");
                Intent getToEditpageintent = new Intent(getApplicationContext(),editsection2.class);
                Log.v("got before button click", "");
                startActivity(getToEditpageintent);
                break;
            default:
                return false;
        }
        return false;
    }


}
