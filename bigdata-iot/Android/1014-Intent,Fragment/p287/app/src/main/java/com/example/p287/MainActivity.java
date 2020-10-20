package com.example.p287;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new Fragment1();
        //fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.fragment);
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        actionBar = getSupportActionBar();
        actionBar.setTitle("FRAGMENTTE");
//        actionBar.setLogo(R.drawable.d1);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
//        actionBar.hide();
    }



    public void ckbt(View v){
        if(v.getId() == R.id.button){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment1).commit();
        } else if(v.getId() == R.id.button2){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment2).commit();
        } else if(v.getId() == R.id.button3){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment3).commit();
        }

    }
}