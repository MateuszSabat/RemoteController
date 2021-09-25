package com.ms.remotecontroller.model;

import com.ms.remotecontroller.controller.serialization.SerialVersionUID;
import com.ms.remotecontroller.view.FieldView;
import com.ms.remotecontroller.view.View;

public class Field extends Model {
    private static final long serialVersionUID = SerialVersionUID.Field;

    private String name = "Field";

    @Override
    protected View createView() {
        return new FieldView();
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
