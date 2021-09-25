package com.ms.remotecontroller.fieldviews;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class GridFieldView<V extends View> implements FieldView<V> {
    private Activity activity;

    private LinearLayout parent;
    private TextView nameView;
    private LinearLayout bottomRow;

    private ArrayList<V> views;
    private int viewsInBottomRow;
    private int maxViewsInRow;

    public GridFieldView(Activity activity, ViewGroup viewGroup, int maxViewsInRow){
        this.activity = activity;
        this.maxViewsInRow = maxViewsInRow;

        parent = createParent(activity);
        nameView = createName(activity);
        bottomRow = createRow(activity);

        parent.addView(nameView);
        parent.addView(bottomRow);
        viewGroup.addView(parent);

        views = new ArrayList<>();
        viewsInBottomRow = 0;
    }
    public GridFieldView(Activity activity, ViewGroup viewGroup, int maxViewsInRow, String name) {
        this(activity, viewGroup, maxViewsInRow);
        setName(name);
    }

    @Override
    public String getName() {
        return nameView.getText().toString();
    }
    @Override
    public void setName(String name) {
        this.nameView.setText(name);
    }

    @Override
    public ArrayList<V> getViews() {
        return views;
    }
    @Override
    public void addView(V view) {
        views.add(view);

        if(viewsInBottomRow == maxViewsInRow){
            bottomRow = createRow(activity);
            parent.addView(bottomRow);
        }

        bottomRow.addView(view);
        viewsInBottomRow++;
    }


    private static LinearLayout createParent(Activity activity){
        LinearLayout parent = new LinearLayout(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        parent.setLayoutParams(params);
        parent.setGravity(Gravity.CENTER);
        parent.setOrientation(LinearLayout.VERTICAL);
        return parent;
    }

    private static TextView createName(Activity activity){
        TextView name = new TextView(activity);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        name.setLayoutParams(params);
        name.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        return name;
    }

    private static LinearLayout createRow(Activity activity){
        LinearLayout row = new LinearLayout(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(params);
        row.setGravity(Gravity.CENTER);
        row.setOrientation(LinearLayout.HORIZONTAL);
        return row;
    }
}
