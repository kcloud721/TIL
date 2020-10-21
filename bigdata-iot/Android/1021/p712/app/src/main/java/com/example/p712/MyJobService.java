package com.example.p712;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyJobService extends Service {
    public MyJobService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
