package com.example.scaryscreenassignment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener{
    GestureDetector gestureDetector;
    RecyclerView rv;
    ArrayList<BookInfo> data;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rcv);
        data = new ArrayList<BookInfo>();
        adapter = new MyAdapter(data,R.layout.booklayout);

        Intent intent = new Intent(this, ScaryScreen.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, 0);

// Get the alarm manager service and schedule it to go off after 10s
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (10 * 1000), pendingIntent);

        BookInfo B1= new BookInfo("Forty Rules of Love" , "Elif Shafak");
        BookInfo B2= new BookInfo("The Bastard of Istanbul" , "Elif Shafak");
        BookInfo B3= new BookInfo("Three Daughters of Eve" , "Elif Shafak");
        BookInfo B4= new BookInfo("The Apprentice" , "Elif Shafak");
        data.add(B1);
        data.add(B2);
        data.add(B3);
        data.add(B4);




        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener()
        {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {

                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if(child != null)
                {

                    Intent ToPage= new Intent(getBaseContext() ,Page.class);
                    startActivity(ToPage);


                }

                return true;
            }
        }

        );


        System.out.print("In main ");
        adapter.notifyDataSetChanged();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnItemTouchListener(this);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        //  Toast.makeText(c,"Intercept called",Toast.LENGTH_SHORT).show();

        gestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }




}

