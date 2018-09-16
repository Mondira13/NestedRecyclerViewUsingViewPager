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

public class HorizontalRecylerAdapter extends RecyclerView.Adapter {

    private final Context context;
    private final List<ItemList> itemsList;
    int IMAGE_TYPE = 0, IMAGE_TEXT_TYPE = 0, TEXT_TYPE = 0;

    public HorizontalRecylerAdapter(Context context, List<ItemList> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }
//    private final int IMAGE_TEXT_TYPE = 0;
//    private final int TEXT_TYPE = 1;
//    private final int IMAGE_TYPE = 2;
//    private ArrayList<CardViewModels> dataSet;

//    public HorizontalRecylerAdapter(Context context, List<ItemList> itemsList) {
//        this.context = context;
//        this.itemsList = itemsList;
//    }

//    @NonNull
//    @Override
//    public HorizontalRecyclerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.recycler_representation_layout, parent, false);
//        return new HorizontalRecyclerAdapterViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull HorizontalRecyclerAdapterViewHolder holder, int position) {
//        String title = itemsList.get(position).getSubList().get(position).getName();
//        String images = itemsList.get(position).getSubList().get(position).getImage();
//        holder.itemName.setText(title);
//        Picasso.get().load(images).into(holder.itemIcons);
//    }
//
//    @Override
//    public int getItemCount() {
//        return itemsList.size();
//    }
//
//
//    public class HorizontalRecyclerAdapterViewHolder extends RecyclerView.ViewHolder {
//
//        ImageView itemIcons;
//        TextView itemName;
//
//        public HorizontalRecyclerAdapterViewHolder(View view) {
//            super(view);
//            itemIcons = view.findViewById(R.id.itemIcon);
//            itemName = view.findViewById(R.id.itemName);
//        }
//    }
//}

// -----------------------------------------------------------------------------------------------------------------

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_image_layout, parent, false);
                return new ViewHolderImage(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_text_layout, parent, false);
                return new ViewHolderText(view);
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_representation_layout, parent, false);
                return new ViewHolderImageWithText(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ItemList list = itemsList.get(position);
        if (itemsList.get(position).getType().equals("Image")) {
            IMAGE_TYPE = 0;
        } else if (itemsList.get(position).getType().equals("Text")) {
            TEXT_TYPE = 1;
        } else if (itemsList.get(position).getType().equals("ImageWithText")) {
            IMAGE_TEXT_TYPE = 2;
        }

        if (list != null) {
            switch (position) {
                case 0:
                    String image = itemsList.get(position).getItemImage();
                    Picasso.get().load(image).into(((ViewHolderImage) holder).imageView);
                case 1:
                    String title1 = itemsList.get(position).getItemText();
                    ((ViewHolderText) holder).textView.setText(title1);
                case 2:
                    String title = itemsList.get(position).getSubList().get(position).getName();
                    String images = itemsList.get(position).getSubList().get(position).getImage();
                    ((ViewHolderImageWithText) holder).itemName.setText(title);
                    Picasso.get().load(images).into(((ViewHolderImageWithText) holder).itemIcons);
            }
        }

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return IMAGE_TYPE;
            case 1:
                return TEXT_TYPE;
            case 2:
                return IMAGE_TEXT_TYPE;
            default:
                return -1;
        }
    }

    public class ViewHolderImageWithText extends RecyclerView.ViewHolder {
        ImageView itemIcons;
        TextView itemName;

        public ViewHolderImageWithText(View view) {
            super(view);
            itemIcons = view.findViewById(R.id.itemIcon);
            itemName = view.findViewById(R.id.itemName);
        }
    }

    public class ViewHolderText extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolderText(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.recyclerText);
        }
    }

    public class ViewHolderImage extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolderImage(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recyclerImage);
        }
    }

}