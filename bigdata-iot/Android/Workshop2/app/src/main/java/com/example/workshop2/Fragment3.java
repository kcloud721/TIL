package com.example.workshop2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

//public class Fragment3 extends Fragment implements View.OnClickListener{
public class Fragment3 extends Fragment{
    MainActivity m;
    NotificationManager manager;
    Button button1; Button button2; Button button3;
    Handler handler = new Handler();

    public Fragment3(MainActivity m) {
        this.m = m;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_3, container, false);
        button1 = viewGroup.findViewById(R.id.button1);
        button2 = viewGroup.findViewById(R.id.button2);
        button3 = viewGroup.findViewById(R.id.button3);

        button1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Vibrator vibrator = (Vibrator) m.getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= 26)
                    vibrator.vibrate(VibrationEffect.createOneShot(100,10));
                else
                    vibrator.vibrate(1000);
            }
        });

        button2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                manager = (NotificationManager) m.getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder = null;
                if (Build.VERSION.SDK_INT >= 26) {
                    if(manager.getNotificationChannel("ch1") == null){
                        manager.createNotificationChannel(
                                new NotificationChannel("ch1","chname",NotificationManager.IMPORTANCE_DEFAULT));
                    }
                    builder = new NotificationCompat.Builder(m, "ch1");
                } else {
                    builder = new NotificationCompat.Builder(m);
                }
                builder.setContentTitle("Noti TEST");
                builder.setContentText("Content TEXT");
                builder.setSmallIcon(R.drawable.a1);
                Notification noti = builder.build();
                manager.notify(1,noti);
            }
        });

        button3.setOnClickListener(new Button.OnClickListener(){
            String result = "";
            @Override
            public void onClick(View view) {
                final String urlStr = "http://192.168.0.70/android/ftest";

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        HttpConnect.getString(urlStr);
                    }
                }).start();

            }
        });


        return viewGroup;
    }


}