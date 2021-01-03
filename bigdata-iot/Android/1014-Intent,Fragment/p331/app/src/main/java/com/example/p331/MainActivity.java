package com.example.p331;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ActionBar actionBar;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1(null);    // fragment에 현재 메인액티비티 전달
        fragment2 = new Fragment2(null);
        fragment3 = new Fragment3(null);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment1).commit();

        actionBar = getSupportActionBar();
        actionBar.hide();

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case (R.id.tab1):
                        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment1).commit();
                        Toast.makeText(MainActivity.this, "tab1", Toast.LENGTH_SHORT).show();
                        break;
                    case (R.id.tab2):
                        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment2).commit();
                        Toast.makeText(MainActivity.this, "tab2", Toast.LENGTH_SHORT).show();
                        break;
                    case(R.id.tab3):
                        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment3).commit();
                        Toast.makeText(MainActivity.this, "tab3", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }

}