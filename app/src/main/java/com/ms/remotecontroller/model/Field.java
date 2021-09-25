package com.ms.remotecontroller.model;

import com.ms.remotecontroller.view.FieldView;
import com.ms.remotecontroller.view.View;

public class Field extends Model {
    private String name = "Field";

    @Override
    protected View createView() {
        return new FieldView();
    }

    public String getName(){
        return name;
    }
}
