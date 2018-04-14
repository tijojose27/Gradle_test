package com.example.androidjokeslib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.javajokeslib.JavaJokes;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke="NO JOKE FROM INTENT";
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            joke = extras.getString("JOKE");
        }

        TextView textView = findViewById(R.id.textView);
        textView.setText(joke);
    }
}
