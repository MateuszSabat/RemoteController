package com.ms.remotecontroller.view.action;

import android.widget.Button;

import com.ms.remotecontroller.view.base.ControllerView;

public class ActionControllerView extends ControllerView {
    @Override
    protected void onFindButton(Button button) {
        button.setText("Edit");
        button.setOnClickListener(view -> getModel().startEdit());
    }
}
