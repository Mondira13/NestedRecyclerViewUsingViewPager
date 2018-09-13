package com.example.enc.nestedrecyclerviewusingviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.enc.nestedrecyclerviewusingviewpager.fragments.BooksFragment;
import com.example.enc.nestedrecyclerviewusingviewpager.fragments.GamesFragment;
import com.example.enc.nestedrecyclerviewusingviewpager.fragments.HomeFragment;
import com.example.enc.nestedrecyclerviewusingviewpager.fragments.MoviesFragment;
import com.example.enc.nestedrecyclerviewusingviewpager.models.Item;

import java.util.ArrayList;
import java.util.List;

public class CustomPagerAdapter  extends FragmentStatePagerAdapter {

    private final List<Item> retrievedData;
    List<Fragment> fragments = new ArrayList<>();


    public CustomPagerAdapter(FragmentManager supportFragmentManager, List<Item> retrievedData) {
        super(supportFragmentManager);
       this.retrievedData = retrievedData;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment item = null;
        switch (retrievedData.get(i).getName()) {
            case "Home":
                item = new HomeFragment();
                break;
            case "Games":
                item = new GamesFragment();
                break;
            case "Movies":
                item = new MoviesFragment();
                break;
            case "Books":
                item = new BooksFragment();
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
