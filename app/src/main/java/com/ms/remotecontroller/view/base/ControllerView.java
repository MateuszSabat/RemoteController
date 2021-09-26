package com.ms.remotecontroller.view.base;

import android.widget.Button;

import com.ms.remotecontroller.R;
import com.ms.remotecontroller.model.Controller;
import com.ms.remotecontroller.view.View;
import com.ms.remotecontroller.view.viewhost.ViewGroupHost;
import com.ms.remotecontroller.view.viewhost.ViewHost;

public abstract class ControllerView extends View<Controller> {
    private ViewHost host;

    @Override
    public void beforeChildrenSpawn() {
        host = new ViewGroupHost(getActivity().findViewById(R.id.base_layout));

        Button button = getActivity().findViewById(R.id.state_button);
        onFindButton(button);
    }
    protected abstract void onFindButton(Button button);

    @Override
    public ViewHost getViewHost() {
        return host;
    }

}
