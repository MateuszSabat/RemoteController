package com.ms.remotecontroller.model;

import com.ms.remotecontroller.controller.serialization.SerialVersionUID;
import com.ms.remotecontroller.view.ButtonView;
import com.ms.remotecontroller.view.View;

public class Button extends Model{
    private static final long serialVersionUID = SerialVersionUID.Button;

    private String name = "Button";

    @Override
    protected View createView() {
        return new ButtonView();
    }

    public String getName(){
        return name;
    }
}
