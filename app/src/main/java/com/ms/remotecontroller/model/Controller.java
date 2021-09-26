package com.ms.remotecontroller.model;

import com.ms.remotecontroller.controller.serialization.SerialVersionUID;
import com.ms.remotecontroller.view.action.ActionControllerView;
import com.ms.remotecontroller.view.View;
import com.ms.remotecontroller.view.edit.EditControllerView;

public class Controller extends Model {
    private static final long serialVersionUID = SerialVersionUID.Controller;

    @Override
    protected View createView(boolean edit) {
        return edit ? new EditControllerView() : new ActionControllerView();
    }

    public void addField(boolean edit){
        addChild(new Field());
        refreshView(edit);
    }

    public void startEdit(){
        refreshView(true);
    }
    public void stopEdit(boolean save) {
        refreshView(false);
    }
}
