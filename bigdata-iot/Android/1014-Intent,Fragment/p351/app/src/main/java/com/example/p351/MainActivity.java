package com.example.p351;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Fragment0 fragment0;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment0 = new Fragment0();
        fragment1 = new Fragment1(this);
        fragment2 = new Fragment2(this);
        fragment3 = new Fragment3(this);
        fragment4 = new Fragment4();

        fragmentManager= getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment0).commit();

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.tab1){
//                    Toast.makeText(MainActivity.this, "tab1", Toast.LENGTH_SHORT).show();
                    fragmentManager.beginTransaction().replace(R.id.framelayout, fragment1).commit();

                } else if(item.getItemId() == R.id.tab2){
//                    Toast.makeText(MainActivity.this, "tab2", Toast.LENGTH_SHORT).show();
                    fragmentManager.beginTransaction().replace(R.id.framelayout, fragment2).commit();

                } else if(item.getItemId() == R.id.tab3){
//                    Toast.makeText(MainActivity.this, "tab3", Toast.LENGTH_SHORT).show();
                    fragmentManager.beginTransaction().replace(R.id.framelayout, fragment3).commit();

                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {     // 상단에 메뉴 표시
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curId = item.getItemId();
        switch (curId) {
            case R.id.menu_setting:
                Toast.makeText(MainActivity.this, "sett", Toast.LENGTH_SHORT).show();
                fragmentManager.beginTransaction().replace(R.id.framelayout, fragment4).commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}