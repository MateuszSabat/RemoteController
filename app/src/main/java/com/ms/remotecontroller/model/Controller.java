package com.ms.remotecontroller.model;

import com.ms.remotecontroller.controller.serialization.SerialVersionUID;
import com.ms.remotecontroller.view.ControllerView;
import com.ms.remotecontroller.view.View;

public class Controller extends Model {
    private static final long serialVersionUID = SerialVersionUID.Controller;

    @Override
    protected View createView() {
        return new ControllerView();
    }
}
