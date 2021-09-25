package com.ms.remotecontroller.view.viewhost;

import android.view.View;
import android.view.ViewGroup;

public class ViewGroupHost implements ViewHost{
    ViewGroup viewGroup;

    public ViewGroupHost(ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
    }

    @Override
    public void addView(View view) {
        viewGroup.addView(view);
    }
    @Override
    public void removeView(View view) {
        viewGroup.removeView(view);
    }
}
