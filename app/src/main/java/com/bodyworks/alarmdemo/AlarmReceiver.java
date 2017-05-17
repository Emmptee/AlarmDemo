package com.bodyworks.alarmdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.socks.library.KLog;

import java.util.Calendar;

/**
 * Created by treycc on 2017/5/17.
 */

public class AlarmReceiver extends WakefulBroadcastReceiver {

    public static final long INTERVAL = 60000 * 3;

    @Override
    public void onReceive(Context context, Intent intent) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0);
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + INTERVAL, broadcast);

        KLog.a(calendar.getTime().toString());

    }
}
