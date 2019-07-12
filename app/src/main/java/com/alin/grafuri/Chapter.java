package com.alin.grafuri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Chapter extends AppCompatActivity implements ChapterAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        setRecyclerView((RecyclerView) findViewById(R.id.recycler_view_chapter));

    }

    private ArrayList<String> getItemList() {

        ArrayList itemList = new ArrayList<String>();
        switch (Objects.requireNonNull(getIntent().getStringExtra(Utils.chapterExtra))) {

            case Utils.theorem:
                 itemList.addAll(Arrays.asList(getResources().getStringArray(R.array.theorem_array)));
                 break;

            case Utils.sentence:
                itemList.addAll(Arrays.asList(getResources().getStringArray(R.array.sentence_array)));
                break;

        }

        return itemList;
    }

    private void setRecyclerView(RecyclerView recyclerView) {

        final ArrayList<String> itemList = getItemList();
        ChapterAdapter adapter = new ChapterAdapter(itemList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);

    }

    @Override
    public void onClick(int position) {
        startActivity(new Intent(Chapter.this, Lesson.class)
                .putExtra(Utils.chapterExtra, getIntent().getStringExtra(Utils.chapterExtra))
                .putExtra(Utils.lessonExtra, position));
    }
}
