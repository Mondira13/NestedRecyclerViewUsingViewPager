package com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk;

import com.example.enc.nestedrecyclerviewusingviewpager.models.HorizontalRecyclerItemsResponse;
import com.example.enc.nestedrecyclerviewusingviewpager.models.TabNamesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("/bins/xtr2g")
    Call<TabNamesResponse> retriveTabNameValues();


    @GET("/bins/l8v20")
    Call<HorizontalRecyclerItemsResponse> retriveHorizontalRecyclerDataValues();















//   https://api.myjson.com/bins/l8v20
}

