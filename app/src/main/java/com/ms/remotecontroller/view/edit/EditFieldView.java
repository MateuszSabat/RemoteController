package com.ms.remotecontroller.view.edit;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ms.remotecontroller.controller.FieldController;
import com.ms.remotecontroller.view.base.ButtonView;
import com.ms.remotecontroller.view.base.FieldView;

public class EditFieldView extends FieldView {
    @Override
    protected TextView createNameView(Activity activity) {
        EditText name = new EditText(activity);
        name.addTextChangedListener(FieldController.fieldNameWatcher(getModel()));
        return name;
    }

    @Override
    public void afterChildrenSpawn() {
        Button button = ButtonView.createButton(getActivity());
        button.setText("+");
        button.setTextSize(20);
        button.setOnClickListener(view -> getModel().addButton(true));
        getViewHost().addView(button);
    }
}
