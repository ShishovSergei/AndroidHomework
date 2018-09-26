package com.gmail.shishovergeiwork.lesson3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gmail.shishovergeiwork.androidhomework.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class Lesson3Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);

        Button urlButton = findViewById(R.id.urlButton);
        final ProgressBar progressBar = findViewById(R.id.progressBar);
        final ImageView urlImage = findViewById(R.id.urlImage);
        final EditText urlText = findViewById(R.id.urlEditText);

        urlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(urlText.getText().toString()))
                    Toast.makeText(Lesson3Activity.this, "URL is empty", Toast.LENGTH_SHORT).show();
                else {
                    progressBar.setVisibility(View.VISIBLE);
                    Picasso.get().load(urlText.getText().toString()).transform(new CircleTransform()).into(urlImage, new Callback(){

                        @Override
                        public void onSuccess() {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(Lesson3Activity.this, "Image is hear!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(Exception e) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(Lesson3Activity.this, "Invalid URL", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });


    }
}
