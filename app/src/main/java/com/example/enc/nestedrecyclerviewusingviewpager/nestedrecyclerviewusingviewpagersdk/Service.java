package com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk;

import com.example.enc.nestedrecyclerviewusingviewpager.models.RecyclerItemsResponse;
import com.example.enc.nestedrecyclerviewusingviewpager.models.TabNamesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("/bins/xtr2g")
    Call<TabNamesResponse> retriveTabNameValues();


    @GET("/bins/tqkgg")
    Call<RecyclerItemsResponse> retriveHorizontalRecyclerDataValues();












//    https://api.myjson.com/bins/tqkgg
}


//  https://api.myjson.com/bins/tpfk8
