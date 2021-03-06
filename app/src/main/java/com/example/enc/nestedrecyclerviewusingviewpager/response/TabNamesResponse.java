package com.example.enc.nestedrecyclerviewusingviewpager.response;

import com.example.enc.nestedrecyclerviewusingviewpager.models.Item;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TabNamesResponse {
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
