package com.ms.remotecontroller.view.base;

import android.app.Activity;
import android.view.ViewGroup;

import com.ms.remotecontroller.model.Button;
import com.ms.remotecontroller.view.View;
import com.ms.remotecontroller.view.viewhost.ViewHost;

public abstract class ButtonView extends View<Button> {
    private android.widget.Button button;

    @Override
    public void beforeChildrenSpawn() {
        button = createButton(getActivity());
        button.setText(getModel().getName());
        onCreateButton(button);
        getParentViewHost().addView(button);
    }
    protected abstract void onCreateButton(android.widget.Button button);

    @Override
    public void onRemove() {
        getParentViewHost().removeView(button);
    }

    @Override
    public ViewHost getViewHost() {
        return null;
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
