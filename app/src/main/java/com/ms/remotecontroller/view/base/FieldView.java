package com.ms.remotecontroller.view.base;

import android.app.Activity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ms.remotecontroller.model.Field;
import com.ms.remotecontroller.view.View;
import com.ms.remotecontroller.view.viewhost.ViewHost;
import com.ms.remotecontroller.view.viewhost.CenteredGrid;

public abstract class FieldView extends View<Field> {
    protected LinearLayout parentView;
    protected TextView nameView;
    protected CenteredGrid gridView;

    @Override
    public void beforeChildrenSpawn() {
        parentView = createParent(getModel().getActivity());
        nameView = createName(getModel().getActivity());
        gridView = new CenteredGrid(getModel().getActivity(), parentView, 3);

        getParentViewHost().addView(parentView);
        parentView.addView(nameView);
    }

    @Override
    public void onRemove() {
        getParentViewHost().removeView(parentView);
    }

    @Override
    public ViewHost getViewHost() {
        return gridView;
    }

    private LinearLayout createParent(Activity activity){
        LinearLayout parent = new LinearLayout(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        parent.setLayoutParams(params);
        parent.setGravity(Gravity.CENTER);
        parent.setOrientation(LinearLayout.VERTICAL);
        return parent;
    }
    private TextView createName(Activity activity){
        TextView name = createNameView(activity);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        name.setLayoutParams(params);
        name.setTextAlignment(android.view.View.TEXT_ALIGNMENT_CENTER);
        name.setPadding(0, 80, 0, 20);
        name.setText(getModel().getName());
        return name;
    }
    protected abstract TextView createNameView(Activity activity);
}
