package com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk;

import com.example.enc.nestedrecyclerviewusingviewpager.response.RecyclerItemsResponse;
import com.example.enc.nestedrecyclerviewusingviewpager.response.TabNamesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("/bins/xtr2g")
    Call<TabNamesResponse> retriveTabNameValues();


    @GET("/bins/1193nb")
    Call<RecyclerItemsResponse> retriveHorizontalRecyclerDataValues();






//   https://api.myjson.com/bins/18hqg4   (add video here) previous used link

//   https://api.myjson.com/bins/1193nb   (modified json link which is used currently)


//    https://api.myjson.com/bins/tqkgg
}



