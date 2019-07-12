package com.alin.grafuri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text_view_theorems).setOnClickListener(this);
        findViewById(R.id.text_view_sentences).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.text_view_theorems:
                startActivity(new Intent(MainActivity.this, Chapter.class)
                        .putExtra(Utils.chapterExtra, Utils.theorem));
                break;

            case R.id.text_view_sentences:
                startActivity(new Intent(MainActivity.this, Chapter.class)
                        .putExtra(Utils.chapterExtra, Utils.sentence));
                break;

        }

    }
}
