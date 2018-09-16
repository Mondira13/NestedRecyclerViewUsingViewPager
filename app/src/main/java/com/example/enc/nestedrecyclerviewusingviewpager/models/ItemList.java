package com.example.enc.nestedrecyclerviewusingviewpager.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mondira on 16-Sep-18.
 */

public class ItemList {
    @SerializedName("itemImage")
    @Expose
    private String itemImage;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("itemText")
    @Expose
    private String itemText;
    @SerializedName("subList")
    @Expose
    private List<SubList> subList = null;

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public List<SubList> getSubList() {
        return subList;
    }

    public void setSubList(List<SubList> subList) {
        this.subList = subList;
    }
}
