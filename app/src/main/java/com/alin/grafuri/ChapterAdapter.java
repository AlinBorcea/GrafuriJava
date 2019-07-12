package com.alin.grafuri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.AdapterHolder> {

    private ArrayList<String> itemList;

    public ChapterAdapter(ArrayList<String> items) {
        this.itemList = items;
    }

    interface OnItemClickListener {
        void onClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    class AdapterHolder extends RecyclerView.ViewHolder {

        private TextView title;

        private AdapterHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_view_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition() != RecyclerView.NO_POSITION)
                        listener.onClick(getAdapterPosition());
                }
            });

        }

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, int position) {
        holder.title.setText((position + 1 + ". " + itemList.get(position)));
    }

    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_lesson, parent, false));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
