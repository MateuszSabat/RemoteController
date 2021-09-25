package com.ms.remotecontroller.model;

import android.app.Activity;

import com.ms.remotecontroller.view.View;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Model implements Serializable {
    transient protected Activity activity;
    transient protected View view;

    protected Model parent;
    protected ArrayList<Model> children = new ArrayList<>();

    protected abstract View createView();

    protected void onInit(){}
    protected void onRemove(){}

    public void init(Activity activity){
        this.activity = activity;
        view = createView();

        view.init(this);
        onInit();

        for(Model child : children){
            child.init(activity);
        }
    }
    public void remove(){
        for(Model child : children){
            child.remove();
        }

        onRemove();
        view.remove();
    }

    public <M extends Model> M addChild(M model){
        model.parent = this;
        children.add(model);
        model.init(activity);
        return model;
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