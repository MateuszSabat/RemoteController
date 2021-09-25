package com.ms.remotecontroller.view;

import android.app.Activity;
import android.view.ViewGroup;

import com.ms.remotecontroller.model.Button;
import com.ms.remotecontroller.view.viewhost.ViewHost;

public class ButtonView extends View<Button> {
    private android.widget.Button button;

    @Override
    public void onInit() {
        button = createButton(getModel().getActivity());
        getParentViewHost().addView(button);
    }

    @Override
    public void onRemove() {
        getParentViewHost().removeView(button);
    }

    @Override
    public ViewHost getViewHost() {
        return null;
    }

    @Override
    public void refresh() {
        button.setText(getModel().getName());
    }

    public static android.widget.Button createButton(Activity activity){
        android.widget.Button button = new android.widget.Button(activity);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        button.setMinWidth(300);
        button.setMinHeight(150);
        return button;
    }
}
