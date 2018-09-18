package com.example.enc.nestedrecyclerviewusingviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.enc.nestedrecyclerviewusingviewpager.models.ItemList;
import com.example.enc.nestedrecyclerviewusingviewpager.models.RecyclerItemsResponse;
import com.example.enc.nestedrecyclerviewusingviewpager.models.SubList;
import com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk.NestedRecyclerViewUsingViewPagerSDK;
import com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk.Service;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainRecyclerAdapterViewHolder> {

    private final Context context;
    private final List<ItemList> itemLists;
    String type = null;

    private static final int VIEW_TYPE_IMAGE = 0;
    private static final int VIEW_TYPE_TEXT = 1;
    private static final int VIEW_TYPE_IMAGE_WITH_TEXT = 2;

    public MainRecyclerAdapter(Context context, List<ItemList> itemLists) {
        this.context = context;
        this.itemLists = itemLists;
    }

    @NonNull
    @Override
    public MainRecyclerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        switch (viewType){
            case VIEW_TYPE_IMAGE:
                return new MainRecyclerAdapterViewHolder(layoutInflater.inflate(
                        R.layout.recycler_image_layout, parent, false), viewType);
            case VIEW_TYPE_TEXT:
                return new MainRecyclerAdapterViewHolder(layoutInflater.inflate(
                        R.layout.recycler_text_layout, parent, false), viewType);
            case VIEW_TYPE_IMAGE_WITH_TEXT:
                return new MainRecyclerAdapterViewHolder(layoutInflater.inflate(
                        R.layout.vertical_recycler_representation_layout, parent, false), viewType);
                default:
                    return new MainRecyclerAdapterViewHolder(layoutInflater.inflate(
                            R.layout.recycler_text_layout, parent, false), viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerAdapterViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case VIEW_TYPE_IMAGE:
                String image = itemLists.get(position).getItemImage();
                Picasso.get().load(image).into(holder.recyclerImageView);
                break;
            case VIEW_TYPE_TEXT:
                String title = itemLists.get(position).getItemText();
                holder.recyclerTextview.setText(title);
                break;
            case VIEW_TYPE_IMAGE_WITH_TEXT:
                holder.horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                RecyclerImageTextAdapter recyclerImageTextAdapter = new RecyclerImageTextAdapter(context,itemLists.get(position).getSubList());
                holder.horizontalRecyclerView.setAdapter(recyclerImageTextAdapter);
                break;
            default:
                break;
        }
//        if (itemLists.get(position).getType().equals("Image")) {
//            type = "Image";
//            HorizontalRecyclerAdapterNew horizontalRecyclerAdapterNew = new HorizontalRecyclerAdapterNew(context, itemLists, type);
//            holder.horizontalRecyclerView.setAdapter(horizontalRecyclerAdapterNew);
//        } else if (itemLists.get(position).getType().equals("Text")) {
//            type = "Text";
//            HorizontalRecyclerAdapterNew horizontalRecyclerAdapterNew = new HorizontalRecyclerAdapterNew(context, itemLists, type);
//            holder.horizontalRecyclerView.setAdapter(horizontalRecyclerAdapterNew);
//        } else if (itemLists.get(position).getType().equals("ImageWithText")) {
//            type = "ImageWithText";
//            HorizontalRecyclerAdapterNew horizontalRecyclerAdapterNew = new HorizontalRecyclerAdapterNew(context, itemLists, type);
//            holder.horizontalRecyclerView.setAdapter(horizontalRecyclerAdapterNew);
//        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (itemLists.get(position).getType()) {
            case "Image":
                return VIEW_TYPE_IMAGE;
            case "Text":
                return VIEW_TYPE_TEXT;
            case "ImageWithText":
                return VIEW_TYPE_IMAGE_WITH_TEXT;
            default:
                return VIEW_TYPE_TEXT;
        }
    }

    //    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


//        if (type.equals("Image")) {
//            String image = itemList.get(position).getItemImage();
//            Picasso.get().load(image).into(((RecyclerImageAdapter.HorizontalImageViewHolder) holder).imageView);
//        } else if (type.equals("Text")) {
//            String title1 = itemList.get(position).getItemText();
//            ((RecyclerImageAdapter.HorizontalTextViewHolder) holder).textView.setText(title1);
//        } else if (type.equals("ImageWithText")) {
//            RecyclerImageTextAdapter recyclerImageTextAdapter = new RecyclerImageTextAdapter(context, subLists);
//            holder.horizontalRecyclerView.setAdapter(recyclerImageTextAdapter);
////            String title = itemList.get(position).getSubList().get(position).getName();
////            String images = itemList.get(position).getSubList().get(position).getImage();
////            ((RecyclerImageAdapter.HorizontalImageWithTextViewHolder) holder).itemName.setText(title);
////            Picasso.get().load(images).into(((RecyclerImageAdapter.HorizontalImageWithTextViewHolder) holder).itemIcons);
//        }
//    }

//    @Override
//    public void onBindViewHolder(@NonNull final MainRecyclerAdapterViewHolder holder, final int position) {
//
//        RecyclerImageAdapter recyclerImageTextAdapter = new RecyclerImageAdapter(context, itemLists,type);
//        holder.horizontalRecyclerView.setAdapter(recyclerImageTextAdapter);


//        HorizontalRecylerAdapter horizontalRecylerAdapter = new HorizontalRecylerAdapter(context,itemLists);
//        holder.horizontalRecyclerView.setAdapter(horizontalRecylerAdapter);

//        if (itemLists.get(position).getType().equals("ImageWithText")) {
//            holder.textView.setVisibility(View.GONE);
//            holder.imageView.setVisibility(View.GONE);
//            holder.horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
//            HorizontalRecylerAdapter horizontalRecylerAdapter = new HorizontalRecylerAdapter(context,itemLists.get(position).getSubList() );
//            holder.horizontalRecyclerView.setAdapter(horizontalRecylerAdapter);
//        }
//        else if (itemLists.get(position).getType().equals("Text")) {
//            holder.horizontalRecyclerView.setVisibility(View.GONE);
//            holder.imageView.setVisibility(View.GONE);
//            String title1 = itemLists.get(position).getItemText();
//            holder.textView.setText(title1);
//        }
//        else if (itemLists.get(position).getType().equals("Image")) {
//            holder.horizontalRecyclerView.setVisibility(View.GONE);
//            holder.textView.setVisibility(View.GONE);
//            String image = itemLists.get(position).getItemImage();
//            Picasso.get().load(image).into(holder.imageView);
//        }
//    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    public class MainRecyclerAdapterViewHolder extends RecyclerView.ViewHolder {

        private ImageView recyclerImageView;
        private TextView recyclerTextview;
        public RecyclerView horizontalRecyclerView;

        public MainRecyclerAdapterViewHolder(View itemView, int itemViewType) {
            super(itemView);
            switch (itemViewType) {
                case VIEW_TYPE_IMAGE:
                    recyclerImageView = itemView.findViewById(R.id.recyclerImageViewId);
                    break;
                case VIEW_TYPE_TEXT:
                    recyclerTextview = itemView.findViewById(R.id.recyclerTextviewId);
                    break;
                case VIEW_TYPE_IMAGE_WITH_TEXT:
                    horizontalRecyclerView = itemView.findViewById(R.id.horizontalRecyclerView);
                    break;
                default:
                    break;
            }
            horizontalRecyclerView = itemView.findViewById(R.id.horizontalRecyclerView);
        }
    }

}
