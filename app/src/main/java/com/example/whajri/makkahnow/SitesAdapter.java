package com.example.whajri.makkahnow;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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

import java.util.List;

public class SitesAdapter extends RecyclerView.Adapter<SitesAdapter.MyViewHolder> {
    List<SiteModel> siteList;
    Context context;
    Resources res;
    String MyColor;


    public SitesAdapter(List<SiteModel> siteList, Context context, Resources res) {
        this.siteList = siteList;
        this.context = context;
        this.res = res;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_site, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SiteModel site = siteList.get(position);
        final float[] roundedCorners = new float[]
                { 5, 5, 5, 5, 5, 5, 5, 5 };
        ShapeDrawable shape = new ShapeDrawable(new RoundRectShape(
                roundedCorners, null, null));
        if (site.getmIndicator() < 30)
            MyColor = "#007A00";
        else if(site.getmIndicator() > 80)
            MyColor = "#a80000";
        else
            MyColor = "#ff9203";


        shape.getPaint().setColor(Color.parseColor(MyColor));
        ClipDrawable clip = new ClipDrawable(shape, Gravity.LEFT,
                ClipDrawable.HORIZONTAL);
        holder.SiteProg.setProgressDrawable(clip);
        holder.SiteImg.setImageResource(site.getmSiteImage());
        holder.SiteProg.setProgress(site.getmIndicator());
        holder.setOnclick(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return siteList.size();
    }


    public void update(List<SiteModel> sites) {
        this.siteList.clear();
        siteList.addAll(sites);
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        //        @BindView(R.id.PostImg)
        ImageView SiteImg;
        //        @BindView(R.id.PostMainTitle)
        ProgressBar SiteProg;




        public MyViewHolder(final View itemView) {
            super(itemView);
            SiteImg = itemView.findViewById(R.id.SiteImg);
            SiteProg = itemView.findViewById(R.id.pb);
        }

        void setOnclick(final int position) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(position == 0) {
                        Intent intent = new Intent(context, DetailedActivity.class);
                        Bundle bundle = new Bundle();
                        SiteModel site = siteList.get(position);
                        bundle.putParcelable(DetailedActivity.SITE_KEY, site);
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
