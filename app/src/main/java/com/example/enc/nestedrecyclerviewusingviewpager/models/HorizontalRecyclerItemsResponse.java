package com.example.enc.nestedrecyclerviewusingviewpager.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HorizontalRecyclerItemsResponse {
    @SerializedName("itemsList")
    @Expose
    private List<ItemsList> itemsList = null;

    public List<ItemsList> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsList> itemsList) {
        this.itemsList = itemsList;
    }
}
