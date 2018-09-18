package com.example.enc.nestedrecyclerviewusingviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.enc.nestedrecyclerviewusingviewpager.models.ItemList;
import com.example.enc.nestedrecyclerviewusingviewpager.models.SubList;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerImageTextAdapter extends RecyclerView.Adapter<RecyclerImageTextAdapter.HorizontalImageWithTextViewHolder> {
    private final Context context;
    private final List<SubList> subList;
//    String type;

    public RecyclerImageTextAdapter(Context context,List<SubList> subList ) {
        this.context  = context;
        this.subList = subList;
    }

    @NonNull
    @Override
    public HorizontalImageWithTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.recycler_representation_layout, parent, false);
        return new HorizontalImageWithTextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalImageWithTextViewHolder holder, int position) {
        String title = subList.get(position).getName();
        String images = subList.get(position).getImage();
//        String title = itemLists.get(position).getSubList().get(position).getName();
//        String images = itemLists.get(position).getSubList().get(position).getImage();
        holder.itemName.setText(title);
        Picasso.get().load(images).into(holder.itemIcons);
    }

    @Override
    public int getItemCount() {
        return subList.size();
    }

    public class HorizontalImageWithTextViewHolder extends RecyclerView.ViewHolder {
        ImageView itemIcons;
        TextView itemName;

        public HorizontalImageWithTextViewHolder(View view) {
            super(view);
            itemIcons = view.findViewById(R.id.itemIcon);
            itemName = view.findViewById(R.id.itemName);
        }
    }
}
