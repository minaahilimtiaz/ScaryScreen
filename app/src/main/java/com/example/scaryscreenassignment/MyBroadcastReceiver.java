package com.example.scaryscreenassignment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import android.os.Bundle;

import static android.content.Context.ALARM_SERVICE;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent i) {
            String action = i.getAction();

            Intent intent = new Intent(context, PrizeScreen.class);

            PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent, 0);



// Get the alarm manager service and schedule it to go off after 10s
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (5 * 1000), pendingIntent);


        }


}
