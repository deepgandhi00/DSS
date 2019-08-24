package com.example.deepgandhi.dsslab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button next,prev,intentTask;

    int images[];

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = new int[3];
        images[0] = R.drawable.ic_android;
        images[1] = R.drawable.ic_arrow_drop_down_circle;
        images[2] = R.drawable.ic_launcher_background;

        imageView = findViewById(R.id.imageViewMain);
        next = findViewById(R.id.btnNext);
        prev = findViewById(R.id.btnPrev);
        intentTask = findViewById(R.id.intentTask);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                next.setEnabled(true);
                prev.setEnabled(true);
                if(count >= images.length){
                    next.setEnabled(false);
                    return;
                }
                imageView.setImageResource(images[count]);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                prev.setEnabled(true);
                next.setEnabled(true);
                if(count < 0){
                    prev.setEnabled(false);
                    return;
                }
                imageView.setImageResource(images[count]);
            }
        });

        intentTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
