package com.example.workshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ActionBar actionBar;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fragment1 = new Fragment1(this);    // fragment에 현재 메인액티비티 전달
        fragment2 = new Fragment2(this);
        fragment3 = new Fragment3(this);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment1).commit();

        actionBar = getSupportActionBar();
        actionBar.hide();

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tab1:
                        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment1).commit();
                        return true;

                    case R.id.tab2:
                        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment2).commit();
                        return true;

                    case R.id.tab3:
                        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment3).commit();
                        return true;
                }
                return false;
            }
        });

    }
}