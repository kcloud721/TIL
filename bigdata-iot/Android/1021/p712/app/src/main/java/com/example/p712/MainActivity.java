package com.example.p712;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    NotificationManager manager;
    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx = findViewById(R.id.textView);
        // Eclipse 프로젝트의 Ftest.java 52line "topics/car" 로 매치됨
        FirebaseMessaging.getInstance().subscribeToTopic("car3").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                String msg = "FCM Complete ...";
                if(!task.isSuccessful()){
                    msg = "FCM Fail";
                }
                Log.d("[TAG]: ", msg);

                manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                ck4(manager);

            }
        });

        // BroadCast Manager 사용하기 위해 OnCreate 마지막에 선언
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);
        lbm.registerReceiver(receiver, new IntentFilter("notification"));
    }

    // MyFService.java의 27 line: intent.putExtra 로 보낸 메시지를 여기서 받음
    public BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent != null){
                String title = intent.getStringExtra("title");
                String control = intent.getStringExtra("control");
                String data = intent.getStringExtra("data");
                tx.setText(control+" "+title+" "+data);
                Toast.makeText(MainActivity.this,
                        title+" "+control+" "+data,Toast.LENGTH_SHORT).show();

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createOneShot(1000,10));
                }else{
                    vibrator.vibrate(1000);
                }
            }
        }
    };


    public void ck4(NotificationManager manager){
        //manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;
        if (Build.VERSION.SDK_INT >= 26) {
            if(manager.getNotificationChannel("ch1") == null){
                manager.createNotificationChannel(
                        new NotificationChannel("ch1","chname",NotificationManager.IMPORTANCE_DEFAULT));
            }
            builder = new NotificationCompat.Builder(this, "ch1");

        } else {
            builder = new NotificationCompat.Builder(this);
        }
        builder.setContentTitle("Noti TEST");
        builder.setContentText("Content TEXT");
        builder.setSmallIcon(R.drawable.a7);
        Notification noti = builder.build();
        manager.notify(1,noti);
    }
}