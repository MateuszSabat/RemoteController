package com.ms.remotecontroller.view;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ms.remotecontroller.controller.FieldController;
import com.ms.remotecontroller.model.Field;
import com.ms.remotecontroller.view.viewhost.ViewHost;
import com.ms.remotecontroller.view.viewhost.CenteredGrid;

public class FieldView extends View<Field> {
    private LinearLayout parent;
    private EditText nameView;
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
    public void onRemove() {
        getParentViewHost().removeView(parent);
    }

    @Override
    public ViewHost getViewHost() {
        return grid;
    }

    @Override
    public void refresh() {
        nameView.setText(getModel().getName());
    }



    private LinearLayout createParent(Activity activity){
        LinearLayout parent = new LinearLayout(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        parent.setLayoutParams(params);
        parent.setGravity(Gravity.CENTER);
        parent.setOrientation(LinearLayout.VERTICAL);
        return parent;
    }
    private EditText createName(Activity activity){
        EditText name = new EditText(activity);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        name.setLayoutParams(params);
        name.setTextAlignment(android.view.View.TEXT_ALIGNMENT_CENTER);
        name.setPadding(0, 80, 0, 20);
        name.addTextChangedListener(FieldController.fieldNameWatcher(getModel()));
        return name;
    }
}
