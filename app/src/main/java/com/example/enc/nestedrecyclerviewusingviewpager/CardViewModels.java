package com.example.enc.nestedrecyclerviewusingviewpager;

public class CardViewModels {

    public static final int IMAGE_TEXT_TYPE=0;
    public static final int TEXT_TYPE=1;
    public static final int IMAGE_TYPE=2;


    public int type;
    public int data;
    public String text;

    public CardViewModels(int type, String text, int data)
    {
        this.type=type;
        this.data=data;
        this.text=text;
    }
}
