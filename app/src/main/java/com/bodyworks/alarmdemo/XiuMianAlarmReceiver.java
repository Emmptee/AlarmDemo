package com.bodyworks.alarmdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.socks.library.KLog;

import java.util.Calendar;

/**
 * Created by treycc on 2017/5/17.
 */

public class XiuMianAlarmReceiver extends WakefulBroadcastReceiver {

    public static final long INTERVAL = 60000 * 5;
    public static final String XIU_MIAN_KEY = "xiu_mian_key";

    @Override
    public void onReceive(Context context, Intent intent) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        Intent endIntent = new Intent(context, XiuMianAlarmReceiver.class);
        boolean booleanExtra = intent.getBooleanExtra(XIU_MIAN_KEY, false);
        endIntent.putExtra(XIU_MIAN_KEY, !booleanExtra);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, endIntent, 0);
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + INTERVAL, broadcast);

        KLog.a(calendar.getTime().toString());

        excute(context, !booleanExtra);
    }

    private void excute(Context context, boolean xiumian) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(xiumian);
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
    }
}
