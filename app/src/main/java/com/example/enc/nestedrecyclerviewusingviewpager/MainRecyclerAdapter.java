package com.example.enc.nestedrecyclerviewusingviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.enc.nestedrecyclerviewusingviewpager.models.ItemsList;
import com.example.enc.nestedrecyclerviewusingviewpager.models.RecyclerItemsResponse;
import com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk.NestedRecyclerViewUsingViewPagerSDK;
import com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRecyclerAdapter  extends RecyclerView.Adapter<MainRecyclerAdapter.MainRecyclerAdapterViewHolder>{

    private final Context context;
//    RecyclerView horizontalRecyclerView;
    Service service;

    public MainRecyclerAdapter(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public MainRecyclerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.vertical_recycler_representation_layout, parent, false);
        return new MainRecyclerAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainRecyclerAdapterViewHolder holder, int position) {

        service = NestedRecyclerViewUsingViewPagerSDK.getClient().create(Service.class);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.horizontalRecyclerView.setLayoutManager(layoutManager);

        Call<RecyclerItemsResponse> call = service.retriveHorizontalRecyclerDataValues();
        call.enqueue(new Callback<RecyclerItemsResponse>() {
            @Override
            public void onResponse(Call<RecyclerItemsResponse> call, Response<RecyclerItemsResponse> response) {

                HorizontalRecylerAdapter horizontalRecylerAdapter = new HorizontalRecylerAdapter(context, response.body().getItemLists());
                holder.horizontalRecyclerView.setAdapter(horizontalRecylerAdapter);
            }

            @Override
            public void onFailure(Call<RecyclerItemsResponse> call, Throwable t) {
                call.cancel();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MainRecyclerAdapterViewHolder extends RecyclerView.ViewHolder {


        public RecyclerView horizontalRecyclerView;

        public MainRecyclerAdapterViewHolder(View itemView) {
            super(itemView);
            horizontalRecyclerView = itemView.findViewById(R.id.horizontalRecyclerView);
        }
    }
}
