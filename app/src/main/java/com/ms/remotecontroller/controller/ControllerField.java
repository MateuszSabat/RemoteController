package com.ms.remotecontroller.controller;

import android.widget.Button;

import com.ms.remotecontroller.fieldviews.FieldView;

public class ControllerField {
    private FieldView<Button> fieldView;
    private FieldData fieldData;

    public ControllerField(FieldView<Button> view, FieldData data){
        this.fieldView = fieldView;
        this.fieldData = fieldData;
    }
}
