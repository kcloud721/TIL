package com.example.p351;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Fragment2 extends Fragment {
    Button button;
    MainActivity m;

    public Fragment2(MainActivity m) {
        this.m = m;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = null;
        viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_2,container,false);
        button = viewGroup.findViewById(R.id.button2_1);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = null;
                progressDialog = new ProgressDialog(m);
                progressDialog.setTitle("Progress Dialog...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();
            }
        });
        return viewGroup;
    }
}