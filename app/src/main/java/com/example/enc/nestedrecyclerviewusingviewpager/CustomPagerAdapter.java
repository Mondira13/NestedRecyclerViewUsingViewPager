package com.example.enc.nestedrecyclerviewusingviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.enc.nestedrecyclerviewusingviewpager.fragments.BaseVerticalFragment;
import com.example.enc.nestedrecyclerviewusingviewpager.models.Item;
import com.example.enc.nestedrecyclerviewusingviewpager.models.ItemList;

import java.util.ArrayList;
import java.util.List;

public class CustomPagerAdapter  extends FragmentStatePagerAdapter {

    private final List<Item> retrievedData;
    List<Fragment> fragments = new ArrayList<>();
//    private final List<ItemList> itemLists;



    public CustomPagerAdapter(FragmentManager supportFragmentManager, List<Item> retrievedData) {
        super(supportFragmentManager);
        this.retrievedData = retrievedData;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment item = null;
        switch (retrievedData.get(i).getName()) {
            case "Home":
//                item = new HomeFragment();
                item = new BaseVerticalFragment();
                break;
            case "Games":
//                item = new GamesFragment();
                item = new BaseVerticalFragment();
                break;
            case "Movies":
//                item = new MoviesFragment();
                item = new BaseVerticalFragment();
                break;
            case "Books":
//                item = new BooksFragment();
                item = new BaseVerticalFragment();
                break;
            default:
                break;
        }
        fragments.add(item);
        return item;
    }

    public Fragment getCurrentItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return retrievedData.size();
    }
}
