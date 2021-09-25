package com.ms.remotecontroller.model;

import com.ms.remotecontroller.view.ControllerView;
import com.ms.remotecontroller.view.View;

public class Controller extends Model {

    @Override
    protected View createView() {
        return new ControllerView();
    }
}
