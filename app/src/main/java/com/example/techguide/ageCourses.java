package com.example.techguide;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.techguide.ageFrags.AgePageAdapter;

public class ageCourses extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    AgePageAdapter pageAdapter;
    TabItem PartOne;
    TabItem PartTwo;
    TabItem PartThree;
    TabItem PartFour;
    TabItem PartFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_courses);

        toolbar = findViewById(R.id.toolbar_agecourses);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tablayoutAge);
         PartOne = findViewById(R.id.tabAge1);
         PartTwo = findViewById(R.id.tabAge2);
        PartThree= findViewById(R.id.tabAge3);
        PartFour = findViewById(R.id.tabAge4);
        PartFive =findViewById(R.id.tabAge5);
        viewPager = findViewById(R.id.viewPagerAge);


        pageAdapter = new AgePageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
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
