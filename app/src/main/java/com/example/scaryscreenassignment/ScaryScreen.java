package com.example.scaryscreenassignment;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScaryScreen extends AppCompatActivity {
    private AudioManager mAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scary_screen);

        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int media_current_volume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int media_max_volume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        mAudioManager.setStreamVolume(
                AudioManager.STREAM_MUSIC, // Stream type
                media_max_volume, // Index
                AudioManager.FLAG_PLAY_SOUND// Flags
        );


       MediaPlayer ring= MediaPlayer.create(ScaryScreen.this,R.raw.dragon);
        ring.start();
        Button DismissBtn = findViewById(R.id.DismissButton);
        DismissBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent BIntent = new Intent(getApplicationContext(), MyBroadcastReceiver.class);
                BIntent.setAction("START_ACTIVITY");
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, BIntent, 0);


                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext() , "1")
                        .setSmallIcon(R.drawable.ic_message_black_24dp)
                        .setContentTitle("0300111222333")
                        .setContentText("You have won Rs. 100,000. Tap to Claim your Prize").setContentIntent(pendingIntent)
                        .setVisibility(100).setColor(25594113).setPriority(NotificationCompat.PRIORITY_MAX)
                        .setAutoCancel(true);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());// notificationId is a unique int for each notification that you must define
                notificationManager.notify(001, mBuilder.build());

                // Code here executes on main thread after user presses button
            }
        });




    }
}
