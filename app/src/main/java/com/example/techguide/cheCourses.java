package com.example.techguide;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.techguide.ageFrags.AgePageAdapter;
import com.example.techguide.cheFrags.ChePageAdapter;

public class cheCourses extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ChePageAdapter pageAdapter;
    TabItem PartOne;
    TabItem PartTwo;
    TabItem PartThree;
    TabItem PartFour;
    TabItem PartFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_che_courses);
        toolbar = findViewById(R.id.toolbar_checourses);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tablayoutChe);
        PartOne = findViewById(R.id.tabChe1);
        PartTwo = findViewById(R.id.tabChe2);
        PartThree= findViewById(R.id.tabChe3);
        PartFour = findViewById(R.id.tabChe4);
        PartFive =findViewById(R.id.tabChe5);
        viewPager = findViewById(R.id.viewPagerChe);


        pageAdapter = new ChePageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

}
