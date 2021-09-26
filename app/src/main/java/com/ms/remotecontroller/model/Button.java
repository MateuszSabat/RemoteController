package com.ms.remotecontroller.model;

import com.ms.remotecontroller.controller.serialization.SerialVersionUID;
import com.ms.remotecontroller.view.action.ActionButtonView;
import com.ms.remotecontroller.view.View;
import com.ms.remotecontroller.view.edit.EditButtonView;

public class Button extends Model{
    private static final long serialVersionUID = SerialVersionUID.Button;

    private String name = "Button";

    @Override
    protected View createView(boolean edit) {
        return edit ? new EditButtonView() : new ActionButtonView();
    }

    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }
}
