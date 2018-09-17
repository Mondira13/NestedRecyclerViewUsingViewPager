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

    public MainRecyclerAdapter(Context context, List<ItemList> itemLists) {
        this.context = context;
        this.itemLists = itemLists;

    }

    @NonNull
    @Override
    public MainRecyclerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.vertical_recycler_representation_layout, parent, false);
        return new MainRecyclerAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final MainRecyclerAdapterViewHolder holder, final int position) {
        if (itemLists.get(position).getType().equals("ImageWithText")) {
            holder.textView.setVisibility(View.GONE);
            holder.imageView.setVisibility(View.GONE);
            holder.horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            HorizontalRecylerAdapter horizontalRecylerAdapter = new HorizontalRecylerAdapter(context,itemLists.get(position).getSubList() );
            holder.horizontalRecyclerView.setAdapter(horizontalRecylerAdapter);
        }
        else if (itemLists.get(position).getType().equals("Text")) {
            holder.horizontalRecyclerView.setVisibility(View.GONE);
            holder.imageView.setVisibility(View.GONE);
            String title1 = itemLists.get(position).getItemText();
            holder.textView.setText(title1);
        }
        else if (itemLists.get(position).getType().equals("Image")) {
            holder.horizontalRecyclerView.setVisibility(View.GONE);
            holder.textView.setVisibility(View.GONE);
            String image = itemLists.get(position).getItemImage();
            Picasso.get().load(image).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    public class MainRecyclerAdapterViewHolder extends RecyclerView.ViewHolder {

        public RecyclerView horizontalRecyclerView;
        ImageView imageView;
        TextView textView;


        public MainRecyclerAdapterViewHolder(View itemView) {
            super(itemView);
            horizontalRecyclerView = itemView.findViewById(R.id.horizontalRecyclerView);
            imageView = itemView.findViewById(R.id.recyclerImage1);
            textView = itemView.findViewById(R.id.recyclerText1);
        }
    }
}
