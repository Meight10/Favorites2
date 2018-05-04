package com.pdm00057616.solarsys.adapters;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pdm00057616.solarsys.MainActivity;
import com.pdm00057616.solarsys.R;
import com.pdm00057616.solarsys.model.Planet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavPlanetAdapter extends RecyclerView.Adapter<FavPlanetAdapter.ViewHolder> {

    private ViewPager vp;
    private ArrayList<Planet> planetArrayList;
    //private LinearLayout linearLayout;

    public FavPlanetAdapter(ArrayList<Planet> planetArrayList, ViewPager vp) {
        this.planetArrayList = planetArrayList;
        this.vp = vp;
        //this.linearLayout=linearLayout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.title.setText(planetArrayList.get(position).getTitle());
        holder.planet.setImageResource(planetArrayList.get(position).getImage());
        if (planetArrayList.get(position).getFav()) {
            holder.fav.setImageResource(R.drawable.star_selected);
        } else {
            holder.fav.setImageResource(R.drawable.star_deselected);
        }
        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.fav.setImageResource(R.drawable.star_deselected);
                planetArrayList.get(position).setFav(false);
                //Snackbar.make(linearLayout, vp.getContext().getText(MainActivity.planetsFav.get(position).getTitle())+" "+vp.getContext().getText(R.string.removed), Snackbar.LENGTH_SHORT).show();
                MainActivity.planetsFav.remove(planetArrayList.get(position));
                vp.getAdapter().notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return planetArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageViewPlanet)
        ImageView planet;
        @BindView(R.id.textViewTitle)
        TextView title;
        @BindView(R.id.imageViewFav)
        ImageButton fav;

        private ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}

