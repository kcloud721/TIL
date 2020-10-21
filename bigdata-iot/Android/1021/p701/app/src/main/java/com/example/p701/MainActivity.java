package com.example.p701;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ck1(View v){
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(100,10));
        }else{
            vibrator.vibrate(1000);
        }

    }
    public void ck2(View v){

    }
    public void ck3(View v){

    }

    // p705
    public void ck4(View v){
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = null;
        if (Build.VERSION.SDK_INT >= 26) {
            if(manager.getNotificationChannel("ch1") == null){
                manager.createNotificationChannel(
                            new NotificationChannel("ch1","chname",NotificationManager.IMPORTANCE_DEFAULT));
                builder = new NotificationCompat.Builder(this, "ch1");
            }
        } else {
            builder = new NotificationCompat.Builder(this);
        }
        builder.setContentTitle("Noti TEST");
        builder.setContentText("Content TEXT");
        builder.setSmallIcon(R.drawable.a7);
        Notification noti = builder.build();
        manager.notify(1,noti);
    }

    // p708
    public void ck5(View v){
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = null;
        if (Build.VERSION.SDK_INT >= 26) {
            if(manager.getNotificationChannel("ch2") == null){
                manager.createNotificationChannel(
                        new NotificationChannel("ch2","chname",NotificationManager.IMPORTANCE_DEFAULT));
                builder = new NotificationCompat.Builder(this, "ch2");
            }
        } else {
            builder = new NotificationCompat.Builder(this);
        }
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,101,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        builder.setContentTitle("Noti TEST");
        builder.setContentText("Content TEXT");
        builder.setSmallIcon(R.drawable.a7);
        Notification noti = builder.build();
        manager.notify(1,noti);
    }
}