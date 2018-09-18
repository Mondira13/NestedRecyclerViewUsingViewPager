package com.example.enc.nestedrecyclerviewusingviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.enc.nestedrecyclerviewusingviewpager.models.ItemList;

import java.util.List;

public class RecyclerTextAdapter extends RecyclerView.Adapter<RecyclerTextAdapter.HorizontalTextViewHolder> {
    Context context;
    private final List<ItemList> itemList;

    public RecyclerTextAdapter(Context context, List<ItemList> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public HorizontalTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.recycler_text_layout, parent, false);
        return new HorizontalTextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalTextViewHolder holder, int position) {
        String title1 = itemList.get(position).getItemText();
        holder.textView.setText(title1);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class HorizontalTextViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public HorizontalTextViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.recyclerTextviewId);
        }
    }
}
