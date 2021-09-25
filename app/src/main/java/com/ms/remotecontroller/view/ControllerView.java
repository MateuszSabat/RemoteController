package com.ms.remotecontroller.view;

import com.ms.remotecontroller.R;
import com.ms.remotecontroller.model.Controller;
import com.ms.remotecontroller.view.viewhost.ViewGroupHost;
import com.ms.remotecontroller.view.viewhost.ViewHost;

public class ControllerView extends View<Controller> {
    private ViewHost host;

    @Override
    public void onInit() {
        host = new ViewGroupHost(getModel().getActivity().findViewById(R.id.base_layout));
    }

    @Override
    public void onRemove() { }

    @Override
    public ViewHost getViewHost() {
        return host;
    }

    @Override
    public void refresh() { }
}
