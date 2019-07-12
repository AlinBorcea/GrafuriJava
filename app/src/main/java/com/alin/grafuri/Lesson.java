package com.alin.grafuri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Lesson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        TextView textView = (TextView) findViewById(R.id.text_view_lesson);
        textView.setText(String.valueOf(getIntent().getIntExtra(Utils.lessonExtra, -1)));
    }
}
