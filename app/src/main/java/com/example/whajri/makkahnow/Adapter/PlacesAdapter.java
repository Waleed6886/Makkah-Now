package com.example.whajri.makkahnow.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.whajri.makkahnow.Activity.DetailedActivity;
import com.example.whajri.makkahnow.Model.PlacesModel;
import com.example.whajri.makkahnow.R;

import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.MyViewHolder> {
    List<PlacesModel> placesList;
    Context context;
    String MyColor;


    public PlacesAdapter(List<PlacesModel> placesList, Context context) {
        this.placesList = placesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_place, parent, false);
        return new PlacesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PlacesModel place = placesList.get(position);
        final float[] roundedCorners = new float[]
                { 5, 5, 5, 5, 5, 5, 5, 5 };
        ShapeDrawable shape = new ShapeDrawable(new RoundRectShape(
                roundedCorners, null, null));
        if (place.getmIndicator() < 30)
            MyColor = "#007A00";
        else if(place.getmIndicator() > 80)
            MyColor = "#a80000";
        else
            MyColor = "#ff9203";


        shape.getPaint().setColor(Color.parseColor(MyColor));
        ClipDrawable clip = new ClipDrawable(shape, Gravity.LEFT, ClipDrawable.HORIZONTAL);
        holder.mPlaceProg.setProgressDrawable(clip);
        holder.mPlaceImg.setImageResource(place.getmPlaceImage());
        holder.mPlaceProg.setProgress(place.getmIndicator());
        holder.mPlaceLevel.setText(String.valueOf(place.getmLevelNumber()));
//        holder.setOnclick(position);
    }



    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }


    public void update(List<PlacesModel> places) {
        this.placesList.clear();
        placesList.addAll(places);
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mPlaceImg;
        private ProgressBar mPlaceProg;
        private TextView mPlaceLevel;




        public MyViewHolder(final View itemView) {
            super(itemView);
            mPlaceImg = itemView.findViewById(R.id.level_icon_detailed_page);
            mPlaceProg = itemView.findViewById(R.id.progressBar_detailed_page);
            mPlaceLevel = itemView.findViewById(R.id.level_number_detailed_page);
        }

        void setOnclick(final int position) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(position == 0) {
                        Intent intent = new Intent(context, DetailedActivity.class);
                        Bundle bundle = new Bundle();
                        PlacesModel place = placesList.get(position);
                        bundle.putParcelable(DetailedActivity.SITE_KEY, place);
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                    else{
                        Snackbar mySnackbar = Snackbar.make(view,"Not supported yet",Snackbar.LENGTH_LONG);
                        mySnackbar.show();

                    }
                }
            });
        }
    }

}
