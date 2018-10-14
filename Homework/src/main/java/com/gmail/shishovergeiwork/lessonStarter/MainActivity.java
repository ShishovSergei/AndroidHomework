package com.gmail.shishovergeiwork.lessonStarter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.gmail.shishovergeiwork.androidhomework.R;
import com.gmail.shishovergeiwork.lesson1.Lesson1Activity;
import com.gmail.shishovergeiwork.lesson2.Lesson2Activity;
import com.gmail.shishovergeiwork.lesson3.Lesson3Activity;
import com.gmail.shishovergeiwork.lesson4.Lesson4Activity;
import com.gmail.shishovergeiwork.lesson5.Lesson5Activity;
import com.gmail.shishovergeiwork.lesson6.Lesson6Activity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lesson1Button = findViewById(R.id.lesson1Button);
        Button lesson2Button = findViewById(R.id.lesson2Button);
        Button lesson3Button = findViewById(R.id.lesson3Button);
        Button lesson4Button = findViewById(R.id.lesson4Button);
        Button lesson5Button = findViewById(R.id.lesson5Button);
        Button lesson6Button = findViewById(R.id.lesson6Button);

        lesson1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showActivity(Lesson1Activity.class);
            }
        });

        lesson2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showActivity(Lesson2Activity.class);
            }
        });
        lesson3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showActivity(Lesson3Activity.class);
            }
        });
        lesson4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showActivity(Lesson4Activity.class);
            }
        });
        lesson5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showActivity(Lesson5Activity.class);
            }
        });
        lesson6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showActivity(Lesson6Activity.class);
            }
        });

    }

    public void showActivity(Class lessonClass) {
        Intent intent = new Intent(MainActivity.this, lessonClass);
        startActivity(intent);
    }


}
