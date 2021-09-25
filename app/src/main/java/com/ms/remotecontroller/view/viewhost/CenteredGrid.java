package com.ms.remotecontroller.view.viewhost;

import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class CenteredGrid implements ViewHost {
    private int size;
    private Activity activity;
    private LinearLayout vertical;
    private ArrayList<Row> rows;

    public CenteredGrid(Activity activity, LinearLayout vertical, int size){
        this.activity = activity;
        this.vertical = vertical;
        this.size = size;
        rows = new ArrayList<>();
    }

    @Override
    public void addView(View view) {
        Row row = null;
        if(rows.size() > 0) {
            row = rows.get(rows.size() - 1);
        }
        if (row == null || row.count() == size) {
            row = new Row(activity, vertical);
            rows.add(row);
        }
        row.add(view);
        Log.d("GRID", Integer.toString(rows.size()));
    }
    @Override
    public void removeView(View view) {
        int i=0;
        while(!rows.get(i).contains(view)) i++;
        rows.get(i).remove(view);
        for(; i < rows.size()-1; i++){
            rows.get(i).add(rows.get(i+1).removeFirst());
        }
        if(rows.get(i).count()==0){
            rows.remove(i).removeItself(vertical);
        }
    }

    public View getRoot(){
        return vertical;
    }
}

class Row {
    private LinearLayout layout;
    private ArrayList<View> views;

    public Row(Activity activity, LinearLayout vertical){
        layout = createLayout(activity);
        vertical.addView(layout);
        views = new ArrayList<>();
    }

    public int count(){
        return views.size();
    }

    public boolean contains(View view){
        return views.contains(view);
    }

    public void add(View view){
        views.add(view);
        layout.addView(view);
    }

    public void remove(View view){
        views.remove(view);
        layout.removeView(view);
    }

    public View removeFirst(){
        return views.remove(0);
    }

    public void removeItself(LinearLayout vertical){
        vertical.removeView(layout);
    }

    private static LinearLayout createLayout(Activity activity){
        LinearLayout row = new LinearLayout(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(params);
        row.setGravity(Gravity.CENTER);
        row.setOrientation(LinearLayout.HORIZONTAL);
        return row;
    }
}
