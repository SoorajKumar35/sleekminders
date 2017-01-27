package com.kumar.sooraj.wastetracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Sooraj on 1/1/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        String TAG = "in the receiver class";
        Intent openAlarm = new Intent(context,openAlarm.class);
        Log.v(TAG, "blue bluah");
        openAlarm.putExtra("pos", intent.getExtras().getInt("pos"));
        context.startService(openAlarm);

    }
}
