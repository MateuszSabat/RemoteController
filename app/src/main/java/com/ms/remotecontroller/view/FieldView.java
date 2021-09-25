package com.ms.remotecontroller.view;

import android.app.Activity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ms.remotecontroller.model.Field;
import com.ms.remotecontroller.view.viewhost.ViewHost;
import com.ms.remotecontroller.view.viewhost.CenteredGrid;

public class FieldView extends View<Field> {
    private LinearLayout parent;
    private TextView nameView;
    private CenteredGrid grid;

    @Override
    public void onInit() {
        parent = createParent(getModel().getActivity());
        nameView = createName(getModel().getActivity());
        grid = new CenteredGrid(getModel().getActivity(), parent, 3);

        parent.addView(nameView);
        getParentViewHost().addView(parent);
    }

    @Override
    public void onRemove() { }

    @Override
    public ViewHost getViewHost() {
        return grid;
    }

    @Override
    public void refresh() {
        nameView.setText(getModel().getName());
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
        name.setTextAlignment(android.view.View.TEXT_ALIGNMENT_CENTER);
        name.setPadding(0, 80, 0, 20);
        return name;
    }
}
