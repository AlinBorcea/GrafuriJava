package com.alin.grafuri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class Lesson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        TextView lessonContent = findViewById(R.id.text_view_lesson);
        lessonContent.setText(getLesson(
                Objects.requireNonNull(getIntent().getStringExtra(Utils.chapterExtra)),
                getIntent().getIntExtra(Utils.lessonExtra, -1)));

    }

    private String getLesson(String chapter, int position) {

        switch (chapter) {

            case Utils.theorem:
                return getResources().getStringArray(R.array.theorem_lessons)[position];

            case Utils.sentence:
                return getResources().getStringArray(R.array.sentence_lessons)[position];

                default: return "No lessons!";

        }

    }

}
