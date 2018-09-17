package com.example.enc.nestedrecyclerviewusingviewpager.fragments;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.enc.nestedrecyclerviewusingviewpager.MainRecyclerAdapter;
import com.example.enc.nestedrecyclerviewusingviewpager.R;
import com.example.enc.nestedrecyclerviewusingviewpager.models.ItemList;
import com.example.enc.nestedrecyclerviewusingviewpager.models.RecyclerItemsResponse;
import com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk.NestedRecyclerViewUsingViewPagerSDK;
import com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("ValidFragment")
public class BaseVerticalFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView verticalRecyclerView;
    Service service;


    private OnFragmentInteractionListener mListener;

//    @SuppressLint("ValidFragment")
//    public BaseVerticalFragment(List<ItemList> itemLists) {
//        this.itemLists = itemLists;
//        // Required empty public constructor
//
//    }

    public BaseVerticalFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_base_vertical, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final List<ItemList> itemLists;
        verticalRecyclerView = view.findViewById(R.id.verticalRecyclerView);
        service = NestedRecyclerViewUsingViewPagerSDK.getClient().create(Service.class);

        // vertical recycler view operation
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Call<RecyclerItemsResponse> call = service.retriveHorizontalRecyclerDataValues();
        call.enqueue(new Callback<RecyclerItemsResponse>() {
            @Override
            public void onResponse(Call<RecyclerItemsResponse> call, Response<RecyclerItemsResponse> response) {
                if(response.body().getResult().equals("success")){
                    MainRecyclerAdapter mainRecyclerAdapter = new MainRecyclerAdapter(getContext(),response.body().getItemList());
                    verticalRecyclerView.setAdapter(mainRecyclerAdapter);
                }

            }

            @Override
            public void onFailure(Call<RecyclerItemsResponse> call, Throwable t) {
                call.cancel();
            }
        });


//        MainRecyclerAdapter mainRecyclerAdapter = new MainRecyclerAdapter(getContext());
//        verticalRecyclerView.setAdapter(mainRecyclerAdapter);


    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
