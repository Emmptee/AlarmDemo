package com.bodyworks.alarmdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.socks.library.KLog;

import java.util.Calendar;

import static com.bodyworks.alarmdemo.XiuMianAlarmReceiver.INTERVAL;
import static com.bodyworks.alarmdemo.XiuMianAlarmReceiver.XIU_MIAN_KEY;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start_alarm(View view) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent startIntent = new Intent(this, XiuMianAlarmReceiver.class);
        startIntent.putExtra(XIU_MIAN_KEY, true);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, startIntent, 0);
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + INTERVAL, broadcast);

        KLog.a("alarm start" + calendar.getTime().toString());
    }
}
