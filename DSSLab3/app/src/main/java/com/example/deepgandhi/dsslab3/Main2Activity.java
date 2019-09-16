package com.example.deepgandhi.dsslab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        message = findViewById(R.id.message);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.INTENT);

        message.setText(msg);
    }
}
