package com.example.enc.nestedrecyclerviewusingviewpager;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.enc.nestedrecyclerviewusingviewpager.models.ItemList;
import com.example.enc.nestedrecyclerviewusingviewpager.models.RecyclerItemsResponse;
import com.example.enc.nestedrecyclerviewusingviewpager.models.SubList;
import com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk.NestedRecyclerViewUsingViewPagerSDK;
import com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk.Service;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainRecyclerAdapterViewHolder> {

    private final Context context;
    private final List<ItemList> itemLists;
    String type = null;

    private static final int VIEW_TYPE_IMAGE = 0;
    private static final int VIEW_TYPE_VIDEO = 1;
    private static final int VIEW_TYPE_TEXT = 2;
    private static final int VIEW_TYPE_IMAGE_WITH_TEXT = 3;

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
            case VIEW_TYPE_VIDEO:
                return new MainRecyclerAdapterViewHolder(layoutInflater.inflate(
                        R.layout.recycler_video_layout, parent, false), viewType);
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
            case VIEW_TYPE_VIDEO:
                String video=itemLists.get(position).getItemVideo();
                Uri videoUri = Uri.parse(video);
                holder.videoView.setVideoURI(videoUri);
                holder.videoView.start();
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
    }

    @Override
    public int getItemViewType(int position) {
        switch (itemLists.get(position).getType()) {
            case "Image":
                return VIEW_TYPE_IMAGE;
            case "Video":
                return VIEW_TYPE_VIDEO;
            case "Text":
                return VIEW_TYPE_TEXT;
            case "ImageWithText":
                return VIEW_TYPE_IMAGE_WITH_TEXT;
            default:
                return VIEW_TYPE_TEXT;
        }
    }



//    @Override
//    public void onBindViewHolder(@NonNull final MainRecyclerAdapterViewHolder holder, final int position) {
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
        public VideoView videoView;

        public MainRecyclerAdapterViewHolder(View itemView, int itemViewType) {
            super(itemView);
            switch (itemViewType) {
                case VIEW_TYPE_IMAGE:
                    recyclerImageView = itemView.findViewById(R.id.recyclerImageViewId);
                    break;
                case VIEW_TYPE_VIDEO:
                    videoView = itemView.findViewById(R.id.recyclerVideoId);
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
