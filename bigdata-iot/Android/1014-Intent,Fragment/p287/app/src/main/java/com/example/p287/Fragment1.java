package com.example.p287;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment1 extends Fragment {
    TextView textView;
    EditText editText;
    Button button4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = null;
        viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_1,container,false);
        textView = viewGroup.findViewById(R.id.textView);
        editText = viewGroup.findViewById(R.id.editText);
        button4 = viewGroup.findViewById(R.id.button4);
        return viewGroup;
        //return inflater.inflate(R.layout.fragment_1, container, false);
    }

    public void setTx(String str){
        textView.setText(str);
    }
}