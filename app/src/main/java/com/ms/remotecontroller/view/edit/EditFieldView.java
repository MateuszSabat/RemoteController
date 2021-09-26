package com.ms.remotecontroller.view.edit;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ms.remotecontroller.controller.FieldController;
import com.ms.remotecontroller.view.base.ButtonView;
import com.ms.remotecontroller.view.base.FieldView;

public class EditFieldView extends FieldView {
    Button removeButton;

    @Override
    protected TextView createNameView(Activity activity) {
        EditText name = new EditText(activity);
        name.addTextChangedListener(FieldController.fieldNameWatcher(getModel()));
        return name;
    }

    @Override
    public void beforeChildrenSpawn() {
        super.beforeChildrenSpawn();
        removeButton = createRemoveButton(getActivity());
        parentView.addView(removeButton);
    }

    @Override
    public void afterChildrenSpawn() {
        super.afterChildrenSpawn();
        Button button = ButtonView.createButton(getActivity());
        button.setText("+");
        button.setTextSize(20);
        button.setOnClickListener(view -> getModel().addButton(true));
        getViewHost().addView(button);
    }

    private Button createRemoveButton(Activity activity){
        Button button = new Button(activity);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        button.setText("-");
        button.setTextSize(20);
        button.setOnClickListener(view -> getModel().remove());
        return button;
    }
}
