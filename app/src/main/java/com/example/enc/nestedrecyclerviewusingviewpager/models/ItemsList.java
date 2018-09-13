package com.example.enc.nestedrecyclerviewusingviewpager.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemsList {
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("name")
    @Expose
    private String name;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
