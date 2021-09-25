package com.ms.remotecontroller.view;

import com.ms.remotecontroller.model.Model;
import com.ms.remotecontroller.view.viewhost.ViewHost;

public abstract class View<M extends Model> {
    private M model;

    public void init(Model model){
        this.model = (M)model;
        onInit();
        refresh();
    }
    public void remove(){
        onRemove();
    }

    public abstract void onInit();
    public abstract void onRemove();
    public abstract ViewHost getViewHost();
    public abstract void refresh();

    protected ViewHost getParentViewHost(){
        return model.getParent().getView().getViewHost();
    }

    public M getModel(){
        return model;
    }
}
