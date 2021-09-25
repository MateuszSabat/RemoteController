package com.ms.remotecontroller.controller;

import android.text.Editable;
import android.text.TextWatcher;

import com.ms.remotecontroller.model.Field;

public class FieldController {
    public static TextWatcher fieldNameWatcher(Field field){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                field.setName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        };
    }
}
