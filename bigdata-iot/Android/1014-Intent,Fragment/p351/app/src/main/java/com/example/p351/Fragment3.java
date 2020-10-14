package com.example.p351;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment3 extends Fragment {
    Button button;
    MainActivity m;

    public Fragment3(MainActivity m) {
        this.m = m;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = null;
        viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_3,container,false);
        button = viewGroup.findViewById(R.id.button3_1);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(m);
                builder.setTitle("Dialog...");
                builder.setMessage("blah blah blah...?");

                builder.setPositiveButton("YES", null);
                builder.setNegativeButton("NO", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        return viewGroup;

    }
}