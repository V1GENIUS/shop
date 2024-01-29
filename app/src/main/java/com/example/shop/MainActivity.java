package com.example.shop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import Adapter.AdapterViewPager;
import Fragments.CategoryFragment;
import Fragments.HomeFragment;
import Fragments.OrderPlaceFragment;
import Fragments.profileFragment;
import Fragments.wishlistFragment;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager ;
    BottomNavigationView bottom_nav;
    ArrayList<Fragment> fragmentArrayList  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
        bottom_nav = findViewById(R.id.bottom_nav);


        fragmentArrayList.add(new HomeFragment());
        fragmentArrayList.add(new CategoryFragment());
        fragmentArrayList.add(new profileFragment());
        fragmentArrayList.add(new wishlistFragment());
        fragmentArrayList.add(new OrderPlaceFragment());

        AdapterViewPager AdapterViewPager = new AdapterViewPager(this,fragmentArrayList);
        //set adaptwer

        if (viewPager != null && AdapterViewPager != null) {
            viewPager.setAdapter(AdapterViewPager);
        }

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottom_nav.setSelectedItemId(R.id.nav_home);
                        break;
                    case 1:
                        bottom_nav.setSelectedItemId(R.id.nav_cat);
                        break;
                    case 2:
                        bottom_nav.setSelectedItemId(R.id.nav_profile);
                        break;
                    case 3:
                        bottom_nav.setSelectedItemId(R.id.nav_wishlist);
                        break;
                    case 4:
                        bottom_nav.setSelectedItemId(R.id.nav_browser);
                        break;

                }

                super.onPageSelected(position);
            }
        });

 // for bottom navigation button click

//        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case android.R.id.nav_home:
//                        viewPager.setCurrentItem(0);
//                        return true;
//                    case  android.R.id.nav_cat:
//                        viewPager.setCurrentItem(1);
//                        return true;
//                    case android.R.id.nav_profile:
//                        viewPager.setCurrentItem(2);
//                        return true;
//                }
//                return true;
//            }
//        });
       // viewPager.setAdapter(AdapterViewPager);
    }
}