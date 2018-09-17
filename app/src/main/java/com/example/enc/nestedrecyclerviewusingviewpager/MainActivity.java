package com.example.enc.nestedrecyclerviewusingviewpager;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.enc.nestedrecyclerviewusingviewpager.fragments.BaseVerticalFragment;
import com.example.enc.nestedrecyclerviewusingviewpager.fragments.BooksFragment;
import com.example.enc.nestedrecyclerviewusingviewpager.fragments.GamesFragment;
import com.example.enc.nestedrecyclerviewusingviewpager.fragments.MoviesFragment;
import com.example.enc.nestedrecyclerviewusingviewpager.models.Item;
import com.example.enc.nestedrecyclerviewusingviewpager.models.TabNamesResponse;
import com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk.NestedRecyclerViewUsingViewPagerSDK;
import com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements BaseVerticalFragment.OnFragmentInteractionListener {

    ViewPager viewPager; // ViewPager allows the user to flip left and right through pages of data.
    private TabLayout tabLayout;
    Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = NestedRecyclerViewUsingViewPagerSDK.getClient().create(Service.class);
        Call<TabNamesResponse> call = service.retriveTabNameValues();


        tabLayout = findViewById(R.id.tabLayout);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });


        call.enqueue(new Callback<TabNamesResponse>() { // its retrive tab names
            @Override
            public void onResponse(Call<TabNamesResponse> call, Response<TabNamesResponse> response) {

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<Item> retrievedData = response.body().getItems();
                        for (int i = 0; i < retrievedData.size();i++){
                            String tabName = retrievedData.get(i).getName();
                            tabLayout.addTab(tabLayout.newTab().setText(tabName));
                        }

                        viewPager.setAdapter( new CustomPagerAdapter(getSupportFragmentManager(), retrievedData));
                    }
                }
            }
            @Override
            public void onFailure(Call<TabNamesResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure..!!! Tab name not uploaded..", Toast.LENGTH_LONG).show();
                call.cancel();

            }
        });


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
