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
import android.widget.Toast;

import com.pdm00057616.solarsys.MainActivity;
import com.pdm00057616.solarsys.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ViewHolder> {

    private ViewPager vp;
    //private LinearLayout linearLayout;

    public PlanetAdapter(ViewPager vp) {
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
        holder.title.setText(MainActivity.planetArrayList.get(position).getTitle());
        holder.planet.setImageResource(MainActivity.planetArrayList.get(position).getImage());
        if (MainActivity.planetArrayList.get(position).getFav()) {
            holder.fav.setImageResource(R.drawable.star_selected);
        } else {
            holder.fav.setImageResource(R.drawable.star_deselected);
        }
        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.planetArrayList.get(position).getFav()) {
                    holder.fav.setImageResource(R.drawable.star_deselected);
                    //Snackbar.make(linearLayout, vp.getContext().getText(MainActivity.planetArrayList.get(position).getTitle())+" "+vp.getContext().getText(R.string.removed), Snackbar.LENGTH_SHORT).show();
                    MainActivity.planetsFav.remove(MainActivity.planetArrayList.get(position));
                    vp.getAdapter().notifyDataSetChanged();
                    MainActivity.planetArrayList.get(position).setFav(false);
                } else {
                    holder.fav.setImageResource(R.drawable.star_selected);
                    MainActivity.planetsFav.add(MainActivity.planetArrayList.get(position));
                    MainActivity.planetArrayList.get(position).setFav(true);
                    vp.getAdapter().notifyDataSetChanged();
                    //Snackbar.make(linearLayout, vp.getContext().getText(MainActivity.planetArrayList.get(position).getTitle())+" "+vp.getContext().getText(R.string.added), Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return MainActivity.planetArrayList.size();
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
