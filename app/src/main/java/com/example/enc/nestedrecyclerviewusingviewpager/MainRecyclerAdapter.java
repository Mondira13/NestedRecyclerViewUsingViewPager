package com.example.enc.nestedrecyclerviewusingviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainRecyclerAdapter  extends RecyclerView.Adapter<MainRecyclerAdapter.MainRecyclerAdapterViewHolder>{


    @NonNull
    @Override
    public MainRecyclerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MainRecyclerAdapterViewHolder extends RecyclerView.ViewHolder {


        public MainRecyclerAdapterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
