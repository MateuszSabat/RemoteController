package com.ms.remotecontroller.view;

import android.app.Activity;

import com.ms.remotecontroller.model.Model;
import com.ms.remotecontroller.view.viewhost.ViewHost;

public abstract class View<M extends Model> {
    private M model;

    public void init(Model model){
        this.model = (M)model;
    }
    public void beforeChildrenSpawn(){}
    public void afterChildrenSpawn(){}

    public void remove(){
        onRemove();
    }

    public void onRemove() { }
    public abstract ViewHost getViewHost();

    protected ViewHost getParentViewHost(){
        return model.getParent().getView().getViewHost();
    }

    public M getModel(){
        return model;
    }
    public Activity getActivity(){
        return getModel().getActivity();
    }
}
