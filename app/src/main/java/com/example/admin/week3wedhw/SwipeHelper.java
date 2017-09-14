package com.example.admin.week3wedhw;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Admin on 9/13/2017.
 */


public class SwipeHelper extends ItemTouchHelper.SimpleCallback {

public static final String TAG = "SwipeHelperTAG";
    RecyclerViewAdapter adapter;

    public SwipeHelper(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }

    public SwipeHelper(RecyclerViewAdapter adapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.RIGHT);
        this.adapter = adapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
adapter.dismissAnimal(viewHolder.getAdapterPosition());
        Log.d(TAG, "onSwiped: "+viewHolder.getAdapterPosition());
    }
}
