package com.example.whajri.makkahnow;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class DetailedActivity extends AppCompatActivity {
    public static String SITE_KEY = "123";
    List<PlacesModel> placesList = new ArrayList<>();
    private PlacesAdapter placesAdapter;
    private ProgressBar mAverageProg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
        createData();
    }
    private void init() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        placesAdapter = new PlacesAdapter(placesList,this);
        RecyclerView recyclerView = findViewById(R.id.detailedRecycleView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(placesAdapter);
//        mAverageProg = findViewById(R.id.average_detailed_progress_bar);

    }
    public void createData() {
        placesList.add(new PlacesModel(R.drawable.ic_kabba,100,0));
        placesList.add(new PlacesModel(R.drawable.ic_fill,50,1));
        placesList.add(new PlacesModel(R.drawable.ic_roof,10,2));
//        mAverageProg.setProgress(40);


    }

}
