package com.pdm00057616.solarsys.fragments;

import android.content.Context;
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

import com.pdm00057616.solarsys.R;
import com.pdm00057616.solarsys.adapters.PlanetAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetFragment extends Fragment {


    private ViewPager vp;
    private LinearLayout linearLayout;



    public PlanetFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.planet_fragment, container, false);
        Context ctx = view.getContext();
        RecyclerView recyclerView = (RecyclerView)view;
        recyclerView.setLayoutManager(new LinearLayoutManager(ctx));
        vp = (ViewPager)getActivity().findViewById(R.id.viewpager);
        PlanetAdapter adapter= new PlanetAdapter(vp);
        recyclerView.setAdapter(adapter);
        return view;
    }


}
