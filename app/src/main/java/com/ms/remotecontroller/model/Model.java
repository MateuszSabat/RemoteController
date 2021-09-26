package com.ms.remotecontroller.model;

import android.app.Activity;

import com.ms.remotecontroller.view.View;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Model implements Serializable {
    transient protected Activity activity;
    transient protected View view;
    transient boolean isInitialized = false;

    protected Model parent;
    protected ArrayList<Model> children = new ArrayList<>();

    protected abstract View createView(boolean edit);


    public void init(Activity activity){
        if(isInitialized) return;
        isInitialized = true;

        this.activity = activity;

        for(Model child : children){
            child.init(activity);
        }
    }

    public void refreshView(boolean edit){
        removeView();
        spawnView(edit);
    }

    private void removeView(){
        for(Model child : children){
            child.removeView();
        }
        if(view != null) {
            view.remove();
            view = null;
        }
    }
    private void spawnView(boolean edit){
        view = createView(edit);
        view.init(this);
        view.beforeChildrenSpawn();
        for(Model child : children){
            child.spawnView(edit);
        }
        view.afterChildrenSpawn();
    }

    public void remove(){
        for(Model child : children){
            child.remove();
        }

        view.remove();
    }

    public <M extends Model> M addChild(M model){
        model.parent = this;
        children.add(model);
        if(isInitialized) {
            model.init(activity);
        }
        return model;
    }

    public boolean isRoot(){
        return parent == null;
    }
    public Activity getActivity(){
        return activity;
    }
    public View getView(){
        return view;
    }
    public Model getParent(){
        return parent;
    }
    public Iterable<Model> getChildren(){
        return children;
    }
}