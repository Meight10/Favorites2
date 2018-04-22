package com.pdm00057616.solarsys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.pdm00057616.solarsys.adapters.ViewPagerAdapter;
import com.pdm00057616.solarsys.fragments.FavPlanetFragment;
import com.pdm00057616.solarsys.fragments.PlanetFragment;
import com.pdm00057616.solarsys.model.Planet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Planet> planetArrayList;
    public static ArrayList<Planet> planetsFav;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            planetArrayList = new ArrayList<>();
            planetsFav = new ArrayList<>();
            setPlanetArrayList();
        }
        init();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }


    private void init() {
        PlanetFragment pf = new PlanetFragment();
        FavPlanetFragment fpf = new FavPlanetFragment();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(pf, getString(R.string.tab1));
        adapter.addFragment(fpf, getString(R.string.tab2));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    private void setPlanetArrayList() {
        planetArrayList.add(new Planet(R.string.sun, R.drawable.sun, false));
        planetArrayList.add(new Planet(R.string.mercury, R.drawable.mercury, false));
        planetArrayList.add(new Planet(R.string.venus, R.drawable.venus, false));
        planetArrayList.add(new Planet(R.string.earth, R.drawable.earth, false));
        planetArrayList.add(new Planet(R.string.mars, R.drawable.mars, false));
        planetArrayList.add(new Planet(R.string.jupiter, R.drawable.jupiter, false));
        planetArrayList.add(new Planet(R.string.saturn, R.drawable.saturn, false));
        planetArrayList.add(new Planet(R.string.uranus, R.drawable.uranus, false));
        planetArrayList.add(new Planet(R.string.neptune, R.drawable.neptune, false));
    }

}
