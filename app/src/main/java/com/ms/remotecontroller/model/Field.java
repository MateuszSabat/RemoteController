package com.ms.remotecontroller.model;

import com.ms.remotecontroller.controller.serialization.SerialVersionUID;
import com.ms.remotecontroller.view.action.ActionFieldView;
import com.ms.remotecontroller.view.View;
import com.ms.remotecontroller.view.edit.EditFieldView;

public class Field extends Model {
    private static final long serialVersionUID = SerialVersionUID.Field;

    private String name = "Field";

    @Override
    protected View createView(boolean edit) {
        return edit ? new EditFieldView() : new ActionFieldView();
    }

    public void addButton(boolean edit){
        addChild(new Button());
        getParent().refreshView(edit);
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
