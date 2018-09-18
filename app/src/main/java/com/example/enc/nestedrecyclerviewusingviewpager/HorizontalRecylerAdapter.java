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
    private final List<ItemList> itemList;
//    String type;
//    final int IT=0,TT=0,ITT=0;

    public HorizontalRecylerAdapter(Context context, List<ItemList> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.recycler_representation_layout, parent, false);
        return new HorizontalImageWithTextViewHolder(view);

//        View view = null;
//        if(type.equals("Image")){
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_image_layout, parent, false);
//                return new HorizontalImageViewHolder(view);
//        }
//        else if(type.equals("Text")){
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_text_layout, parent, false);
//                return new HorizontalTextViewHolder(view);
//        }
//        else if(type.equals("ImageWithText")){
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_recycler_representation_layout, parent, false);
//                return new HorizontalImageWithTextViewHolder(view);
//        }
//        switch (viewType) {
//            case type:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_image_layout, parent, false);
//                return new HorizontalImageViewHolder(view);
//            case type:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_text_layout, parent, false);
//                return new HorizontalTextViewHolder(view);
//            case type:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_recycler_representation_layout, parent, false);
//                return new HorizontalImageWithTextViewHolder(view);
//        }
//         return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        String title = itemList.get(position).getSubList().get(position).getName();
//        String images = itemList.get(position).getSubList().get(position).getImage();
//        holder.itemName.setText(title);
//        Picasso.get().load(images).into(holder.itemIcons);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }




//    @Override
//    public int getItemViewType(int position) {
//
//        switch (itemList.size()) {
//            case 0:
//                return ModelType.IMAGE_TYPE;
//            case 1:
//                return ModelType.TEXT_TYPE;
//            case 2:
//                return ModelType.IMAGE_TEXT_TYPE;
//            default:
//                return -1;
//        }
//    }


//    @Override
//    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
//        if(type.equals("Image")){
//            String image = itemList.get(position).getItemImage();
//            Picasso.get().load(image).into(((HorizontalImageViewHolder) holder).imageView);
//        }else if(type.equals("Text")){
//            String title1 = itemList.get(position).getItemText();
//            ((HorizontalTextViewHolder) holder).textView.setText(title1);
//        }
//        else if(type.equals("ImageWithText")){
//            String title = itemList.get(position).getSubList().get(position).getName();
//            String images = itemList.get(position).getSubList().get(position).getImage();
//            ((HorizontalImageWithTextViewHolder) holder).itemName.setText(title);
//            Picasso.get().load(images).into(holder.itemIcon);





//        ItemList object = itemList.get(position);
//        if (object != null) {
//            switch (position) {
//                case ModelType.IMAGE_TYPE:
//                    String image = itemList.get(position).getItemImage();
//                    Picasso.get().load(image).into(((HorizontalImageViewHolder) holder).imageView);
//                    break;
//                case ModelType.TEXT_TYPE:
//                    String title1 = itemList.get(position).getItemText();
//                    ((HorizontalTextViewHolder) holder).textView.setText(title1);
//                    break;
//                case ModelType.IMAGE_TEXT_TYPE:
//                    String title = itemList.get(position).getSubList().get(position).getName();
//                    String images = itemList.get(position).getSubList().get(position).getImage();
//                    ((HorizontalImageWithTextViewHolder) holder).itemName.setText(title);
//                    Picasso.get().load(images).into(((HorizontalImageWithTextViewHolder) holder).itemIcons);
//            }
//
//        }

//    }

//    @Override
//    public void onBindViewHolder(@NonNull HorizontalImageWithTextViewHolder holder, int position) {
//        String title = itemList.get(position).getSubList().get(position).getName();
//        String images = itemList.get(position).getSubList().get(position).getImage();
//        holder.itemName.setText(title);
//        Picasso.get().load(images).into(holder.itemIcons);
//    }




//--------------------------------------------------------------------------------------------------


//    private class HorizontalImageViewHolder extends RecyclerView.ViewHolder {
//        ImageView imageView;
//
//        public HorizontalImageViewHolder(View view) {
//            super(view);
//            imageView = view.findViewById(R.id.recyclerImageViewId);
//        }
//
//    }
//
//    private class HorizontalTextViewHolder extends RecyclerView.ViewHolder {
//        TextView textView;
//
//        public HorizontalTextViewHolder(View view) {
//            super(view);
//            textView = view.findViewById(R.id.recyclerTextviewId);
//        }
//    }

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

