package com.example.p251;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void ckbt(View v){
        Intent intent = null;
        if(v.getId() == R.id.button3){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1234-1234"));
            startActivity(intent);
        }else if(v.getId() == R.id.button4){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
            startActivity(intent);
        }else if(v.getId() == R.id.button5){
            int check = PermissionChecker.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if(check == PackageManager.PERMISSION_GRANTED){
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-0000-0000"));
                startActivity(intent);
            } else {
                Toast.makeText(this,"NOT Allowed", Toast.LENGTH_SHORT);
            }
        }
//        startActivity(intent);
    }
}