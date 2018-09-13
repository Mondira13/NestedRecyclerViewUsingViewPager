package com.example.enc.nestedrecyclerviewusingviewpager.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecyclerItemsResponse {
    @SerializedName("itemLists")
    @Expose
    private List<ItemsList> itemLists = null;

    public List<ItemsList> getItemLists() {
        return itemLists;
    }

    public void setItemLists(List<ItemsList> itemLists) {
        this.itemLists = itemLists;
    }

}
