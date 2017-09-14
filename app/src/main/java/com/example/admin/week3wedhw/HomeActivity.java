package com.example.admin.week3wedhw;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rvPersonList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    private static final String TAG = "HomeActivityTag";
    List<Animal> animalList;
    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Stetho.initializeWithDefaults(this);

        Log.d(TAG, "onCreate: ");
        firstRunCheck();

        animalList = readAllAnimalsInformationDatabase();

        Log.d(TAG, "onCreateSIZE: "+animalList.size());
        for (int i = 0; i < animalList.size(); i++) {
            Log.d(TAG, "onCreateSIZESHOW: "+ animalList.get(i).getANIMAL_NAME()+ " "+ animalList.get(i).getANIMAL_ID());

        }


        rvPersonList = (RecyclerView) findViewById(R.id.rvPersonList);


        RecyclerViewAdapter adapter = new RecyclerViewAdapter( animalList);
        rvPersonList.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvPersonList.setLayoutManager(layoutManager);
        rvPersonList.setItemAnimator(itemAnimator);


        ItemTouchHelper.Callback callback = new SwipeHelper(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rvPersonList);

    }

    private void firstRunCheck() {

        int sizeOfDatabase = databaseHelper.readAllAnimalsInformation().size();
        Log.d(TAG, "firstRunCheckInitial: " +sizeOfDatabase);
        if (sizeOfDatabase == 0)
            autoPopulate();
    }


    public void autoPopulate() {

        try {
            databaseHelper.createAnimal("Lion", "Feline", 34, 350, R.drawable.lion);
            databaseHelper.createAnimal("Tiger", "Feline", 30, 330, R.drawable.tiger);
            databaseHelper.createAnimal("Condor", "Feline", 43, 190, R.drawable.condor);
            databaseHelper.createAnimal("Hawk", "Feline", 14, 160, R.drawable.hawk);
            databaseHelper.createAnimal("GoldFish", "Feline", 4, 1, R.drawable.goldfish);
            Log.d(TAG, "initializeData: " + "Completed");
        } catch (Exception e) {
            Log.d(TAG, "initializeData err: " + e.toString());
        }

    }

    public List<Animal> readAllAnimalsInformationDatabase() {
        return databaseHelper.readAllAnimalsInformation();
    }


}
