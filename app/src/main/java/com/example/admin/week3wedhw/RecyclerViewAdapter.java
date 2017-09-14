package com.example.admin.week3wedhw;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 9/13/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private static final String TAG = "RecyclerViewAdapter";
    List<Animal> animalList = new ArrayList<>();
    private DatabaseHelper writableDatabase;
Context context;

    public RecyclerViewAdapter( List<Animal> animalList) {
     //   this.c = c;
        this.animalList = animalList;
        Log.d(TAG, "RecyclerViewAdapter size: " +animalList.size());
    }

    public DatabaseHelper getWritableDatabase() {
        return writableDatabase;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName ;//=// //view.findViewById(R.id.tvPersonName);
        private TextView tvType; //= //vi/ew.findViewById(R.id.tvPersonAge);
        private TextView tvAge;
        private TextView tvWeight; //= view.findViewById(R.id.tvPersonHeight);
private ImageView imageDisplay;


        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvType = itemView.findViewById(R.id.tvType);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvWeight = itemView.findViewById(R.id.tvWeight);
            imageDisplay = itemView.findViewById(R.id.imageDisplay);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        context = parent.getContext();
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_list_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder position: "+position);
        Animal animal = animalList.get(position);

        holder.tvName.setText(animal.getANIMAL_NAME());
        holder.tvType.setText(animal.getANIMAL_TYPE());
        holder.tvAge.setText(String.valueOf(animal.getANIMAL_AGE()));
        holder.tvWeight.setText(String.valueOf(animal.getANIMAL_WEIGHT()));

        holder.imageDisplay.setImageResource(animal.getANIMAL_IMAGE());
        Log.d(TAG, "onBindViewHolder ima: " +animal.getANIMAL_IMAGE() );
       // holder.imageDisplay.setMaxHeight(100);
    }

    @Override
    public int getItemCount() {
        //    Log.d(TAG, "getItemCount: "+ personList.size());
        return animalList.size();
    }

    //Dismiss
    public void dismissAnimal(int pos) {

        Log.d(TAG, "deleteid ada: " + pos + animalList.get(pos).getANIMAL_ID());

        for (int i = 0; i <animalList.size() ; i++) {
            Log.d(TAG, "deleteid info: "+ animalList.get(i).getANIMAL_ID());

        }
        try {
            DatabaseHelper databaseHelper = new DatabaseHelper(context);
            databaseHelper.delete(this.animalList.get(pos).getANIMAL_ID());
        }
        catch(Exception e){
            Log.d(TAG, "deleteid ada er: " + e.toString());
        }
        this.animalList.remove(pos);
        this.notifyItemRemoved(pos);
    }
}
