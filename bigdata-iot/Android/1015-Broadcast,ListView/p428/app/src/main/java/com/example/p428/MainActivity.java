package com.example.p428;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater layoutInflater = getLayoutInflater();
        View dview = layoutInflater.inflate(R.layout.dialog, (ViewGroup) findViewById(R.id.dlayout));
        ImageView dimg = dview.findViewById(R.id.imageView2);
        dimg.setImageResource(persons.get(position).getImg);
        builder.setView(dview);

        builder.setTitle("Hi");
        builder.setMessage("Name: "+persons.get(position).getName());
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

    }
}