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

public class HorizontalRecylerAdapter extends RecyclerView.Adapter<HorizontalRecylerAdapter.HorizontalRecyclerAdapterViewHolder> {

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

        String title = itemsList.get(position).getImage();  // getImage() method retrive name
        String images = itemsList.get(position).getName();  // getName() method retrive images
        holder.itemName.setText(title);
        Picasso.get().load(images).into(holder.itemIcons);

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

//
//    @Override
//    public int getItemViewType(int position) {
//
//        switch (itemsList.get(position).type) {
//            case 0:
//                return CardViewModels.IMAGE_TEXT_TYPE;
//
//            case 1:
//                return CardViewModels.TEXT_TYPE;
//
//            case 2:
//                return CardViewModels.IMAGE_TYPE;
//
//            default:
//                return -1;
//        }
//    }
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        View view;
//        switch (viewType) {
//            case CardViewModels.IMAGE_TEXT_TYPE:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_representation_layout, parent, false);
//                return new ViewHolderImageWithText(view);
//
//            case CardViewModels.TEXT_TYPE:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_text_layout, parent, false);
//                return new ViewHolderText(view);
//
//            case CardViewModels.IMAGE_TYPE:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_image_layout, parent, false);
//                return new ViewHolderImage(view);
//        }
//        return null;
//    }



  public class HorizontalRecyclerAdapterViewHolder extends RecyclerView.ViewHolder {

        ImageView itemIcons;
        TextView itemName;

        public HorizontalRecyclerAdapterViewHolder(View view) {
            super(view);
            itemIcons = view.findViewById(R.id.itemIcon);
            itemName = view.findViewById(R.id.itemName);
        }
    }


//    --------------------------------------------------------------------------------------------------------

//
//    public class ViewHolderImageWithText extends RecyclerView.ViewHolder {
//
//        ImageView itemIcons;
//        TextView itemName;
//
//        public ViewHolderImageWithText(View view) {
//            super(view);
//            itemIcons = view.findViewById(R.id.itemIcon);
//            itemName = view.findViewById(R.id.itemName);
//        }
//    }
//
//    public class ViewHolderText extends RecyclerView.ViewHolder {
//        TextView textView;
//
//        public ViewHolderText(View itemView) {
//            super(itemView);
//            textView = itemView.findViewById(R.id.recyclerText);
//        }
//    }
//
//    public class ViewHolderImage extends RecyclerView.ViewHolder {
//        ImageView imageView;
//
//        public ViewHolderImage(View itemView) {
//            super(itemView);
//            imageView = itemView.findViewById(R.id.recyclerImage);
//        }
//    }
}

