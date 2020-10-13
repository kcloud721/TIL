package com.example.p245;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    LinearLayout container;
    String id;
    String pwd;

    EditText editInfo;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(4);
        container = findViewById(R.id.container);
    }

    public void clickb1(View v){    // 로그인시 프로그레스바 진행
        progressBar.setProgress(1);
        container.removeAllViews(); // 현재 화면 지우기가 선행되어야 함
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.p1, container, true);
        EditText editID = (EditText) findViewById(R.id.editId);
        EditText editPWD = (EditText) findViewById(R.id.editPwd);
        id = editID.getText().toString();
        pwd = editPWD.getText().toString();

    }
    public void clickb2(View v){    // 회원가입시 다이얼로그 진행
        Toast.makeText(this, id+" / "+pwd, Toast.LENGTH_SHORT).show();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("회원가입");
        builder.setMessage("CONTINUE?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        progressBar.setProgress(2);

    }
    public void clickb3(View v){    // 회원정보 화면에서는 데이터 수정 가능
        progressBar.setProgress(3);
        editInfo = (EditText) findViewById(R.id.editInfo); // 전역변수로 잡으니까 꺼지는 오류 해결
        textResult = (TextView) findViewById(R.id.textResult);
        Button modify = (Button) findViewById(R.id.modify);

        container.removeAllViews(); // 현재 화면 지우기가 선행되어야 함
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.p3, container, true);

        if(v.getId() == R.id.modify){
            Toast.makeText(this, editInfo.getText(), Toast.LENGTH_SHORT).show();

            if(convertView != null)
                textResult = (TextView)convertView.findViewById(R.id.textResult);
            textResult.setText(editInfo.getText());
        }
    }

    public void clickb4(View v){    // 회원 리스트 정보에는 커다란 이미지를 넣고 위아래로 스크롤 p.164
        progressBar.setProgress(4);
        container.removeAllViews(); // 현재 화면 지우기가 선행되어야 함
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.p4, container, true);
    }
}