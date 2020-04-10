package com.example.scaryscreenassignment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrizeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize_screen);


        Button Claim = findViewById(R.id.ClaimButton);
        Claim.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), ScaryScreen.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, 0);

// Get the alarm manager service and schedule it to go off after 10s
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (0* 1000), pendingIntent);

                // Code here executes on main thread after user presses button
            }
        });
    }




}
