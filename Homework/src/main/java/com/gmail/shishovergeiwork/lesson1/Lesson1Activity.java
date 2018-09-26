package com.gmail.shishovergeiwork.lesson1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gmail.shishovergeiwork.androidhomework.R;

public class Lesson1Activity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);

        Button button = findViewById(R.id.button1);
        final TextView textView1 = findViewById(R.id.textView1);
        final TextView textView2 = findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swap(textView1, textView2);
            }
        });

        View.OnClickListener textView1OnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swap(textView1, textView2);
            }
        };
        textView1.setOnClickListener(textView1OnClickListener);

        textView2.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        swap(textView1,textView2);
    }

    private void swap(TextView textView1, TextView textView2) {
        CharSequence tempText = textView1.getText();
        Drawable tempBackground = textView1.getBackground();

        textView1.setBackground(textView2.getBackground());
        textView1.setText(textView2.getText());

        textView2.setBackground(tempBackground);
        textView2.setText(tempText);
    }
}
