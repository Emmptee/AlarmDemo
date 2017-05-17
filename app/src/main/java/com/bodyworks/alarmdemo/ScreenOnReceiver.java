package com.bodyworks.alarmdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.socks.library.KLog;

/**
 * Created by treycc on 2017/5/17.
 */

public class ScreenOnReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        KLog.a("screen open receive");
    }
}
