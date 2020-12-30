package com.example.nfctest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_URI = 2;

    EditText mWriteText;
    NfcAdapter mNfcAdapter;
    PendingIntent mPendingIntent;

    Button r;
    Button w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = findViewById(R.id.button);
        r = findViewById(R.id.button2);

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ReadActivity.class);
                startActivity(intent);
            }
        });

        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                public void onClick(View v) {
////                    Intent intent = new Intent(getBaseContext(), WriteActivity.class);
////                    startActivity(intent);
//                }
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null)
            return;

        Tag detectedTag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        System.out.println(detectedTag);
//        writeTag(getTextAsNdef(), detectedTag);

    }

    private NdefMessage getTextAsNdef() {
        byte[] textBytes = mWriteText.getText().toString().getBytes();
        NdefRecord textRecord = new NdefRecord(NdefRecord.TNF_MIME_MEDIA,
                "text/plain".getBytes(),
                new byte[] {},
                textBytes);

        return new NdefMessage(new NdefRecord[] {textRecord});
    }

    private NdefMessage getUriAsNdef() {

        byte[] textBytes = mWriteText.getText().toString().getBytes();

        NdefRecord record1 = new NdefRecord(NdefRecord.TNF_WELL_KNOWN,
                new String("U").getBytes(Charset.forName("US-ASCII")),
                new byte[0],
                textBytes) ;

        return new NdefMessage(new NdefRecord[] {record1});
    }

    private void toast(String text) {
        Log.i("fureun","toast");
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}