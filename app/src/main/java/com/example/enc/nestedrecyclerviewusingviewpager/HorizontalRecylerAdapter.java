package com.example.enc.nestedrecyclerviewusingviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.enc.nestedrecyclerviewusingviewpager.models.ItemsList;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HorizontalRecylerAdapter extends RecyclerView.Adapter<HorizontalRecylerAdapter.HorizontalRecyclerAdapterViewHolder>{

    private final Context context;
    private final List<ItemsList> itemsList;

    public HorizontalRecylerAdapter(Context context, List<ItemsList> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }


    @NonNull
    @Override
    public HorizontalRecyclerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.recycler_representation_layout, parent, false);
        return new HorizontalRecyclerAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRecyclerAdapterViewHolder holder, int position) {

        String title = itemsList.get(position).getName();
        String images = itemsList.get(position).getImage();
        holder.itemName.setText(title);
        Picasso.get().load(images).into(holder.itemIcons);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HorizontalRecyclerAdapterViewHolder extends RecyclerView.ViewHolder {

        ImageView itemIcons;
        TextView itemName;

        public HorizontalRecyclerAdapterViewHolder(View view) {
            super(view);
            itemIcons = view.findViewById(R.id.itemIcon);
            itemName = view.findViewById(R.id.itemName);
        }
    }
}
