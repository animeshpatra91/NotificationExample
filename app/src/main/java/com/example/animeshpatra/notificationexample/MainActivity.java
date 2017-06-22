package com.example.animeshpatra.notificationexample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnShow, btnClear;
    NotificationManager manager;
    Notification myNotication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialise();

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        btnShow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //API level 11
                Intent intent = new Intent(MainActivity.this,MainActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 1, intent, 0);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);

                builder.setAutoCancel(true);
                builder.setColor(Color.parseColor("#FF0000"));
                builder.setTicker("this is ticker text");
                builder.setContentTitle("WhatsApp Notification");
                builder.setContentText("You have a new message");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentIntent(pendingIntent);
                builder.setOngoing(false);
                builder.setSubText("This is subtext...");   //API level 16
                builder.setNumber(100);

                manager.notify(11, builder.build());

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                manager.cancel(11);
            }
        });
    }

    private void initialise() {
        btnShow = (Button) findViewById(R.id.btnShowNotification);
        btnClear = (Button) findViewById(R.id.btnClearNotification);
    }
}
