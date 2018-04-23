package com.pdm00057616.solarsys.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pdm00057616.solarsys.MainActivity;
import com.pdm00057616.solarsys.R;
import com.pdm00057616.solarsys.adapters.FavPlanetAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavPlanetFragment extends Fragment {

    private ViewPager vp;
    private LinearLayout linearLayout;

    @BindView(R.id.recyclerviewFav)
    RecyclerView recyclerView;

    public FavPlanetFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fav_planet_fragment, container, false);
        ButterKnife.bind(this, view);
        vp = getActivity().findViewById(R.id.viewpager);
        linearLayout=getActivity().findViewById(R.id.linearLayoutSnackbarPlanet);
        FavPlanetAdapter adapter = new FavPlanetAdapter(MainActivity.planetsFav, vp, linearLayout);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}
