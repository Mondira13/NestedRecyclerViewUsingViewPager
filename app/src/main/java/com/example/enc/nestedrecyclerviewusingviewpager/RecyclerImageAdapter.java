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
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerImageAdapter extends RecyclerView.Adapter {

    Context context;
    private final List<ItemList> itemList;
    String type;

    public RecyclerImageAdapter(Context context, List<ItemList> itemList, String type) {
        this.context = context;
        this.itemList = itemList;
        this.type = type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(type.equals("Image")){
            View view = layoutInflater.inflate(R.layout.recycler_image_layout, parent, false);
            return new HorizontalImageViewHolder(view);
        }
        else if(type.equals("Text")){
            View view = layoutInflater.inflate(R.layout.recycler_text_layout, parent, false);
            return new HorizontalTextViewHolder(view);
        }
        else if(type.equals("ImageWithText")){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_representation_layout, parent, false);
                return new HorizontalImageWithTextViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(type.equals("Image")) {
            String image = itemList.get(position).getItemImage();
            Picasso.get().load(image).into(((HorizontalImageViewHolder)holder).imageView);
        }
         else if(type.equals("Text")) {
            String title1 = itemList.get(position).getItemText();
            ((HorizontalTextViewHolder) holder).textView.setText(title1);
        }
        else if(type.equals("ImageWithText")) {
            String title = itemList.get(position).getSubList().get(position).getName();
                    String images = itemList.get(position).getSubList().get(position).getImage();
                    ((HorizontalImageWithTextViewHolder) holder).itemName.setText(title);
                    Picasso.get().load(images).into(((HorizontalImageWithTextViewHolder) holder).itemIcons);
        }
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class HorizontalImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public HorizontalImageViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.recyclerImageViewId);
        }

    }
    public class HorizontalTextViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public HorizontalTextViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.recyclerTextviewId);
        }
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
