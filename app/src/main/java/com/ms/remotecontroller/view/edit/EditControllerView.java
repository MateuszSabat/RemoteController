package com.ms.remotecontroller.view.edit;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.Button;

import com.ms.remotecontroller.view.base.ControllerView;

public class EditControllerView extends ControllerView {
    Button addButton;
    @Override
    protected void onFindButton(Button button) {
        button.setText("Save");
        button.setOnClickListener(view -> getModel().stopEdit(true));
    }

    @Override
    public void afterChildrenSpawn() {
        super.afterChildrenSpawn();
        addButton = createAddButton(getActivity());
        getViewHost().addView(addButton);
    }

    @Override
    public void onRemove() {
        super.onRemove();
        getViewHost().removeView(addButton);
    }

    private Button createAddButton(Activity activity){
        Button button = new android.widget.Button(activity);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        button.setTextSize(20);
        button.setText("+");
        button.setOnClickListener(view -> getModel().addField(true));
        return button;
    }
}
