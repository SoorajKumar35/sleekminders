package com.kumar.sooraj.wastetracker;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.AlarmClock;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Sooraj on 1/1/2017.
 */

public class openAlarm extends Service {
    String TAG = "alarm service class";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle pos = intent.getExtras();
        int position = pos.getInt("pos");
        Log.v(TAG, "awwww yeahhh");
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(),notification);
        r.play();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.stop();
        /*Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        Intent returny = new Intent(openAlarm.this, trackerfront.class);
        returny.putExtra("pos", position);
        startActivity(returny);*/
       // startActivity(i);
        return START_NOT_STICKY;


    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }


}
