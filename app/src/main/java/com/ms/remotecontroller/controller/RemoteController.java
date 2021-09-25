package com.ms.remotecontroller.controller;

import android.app.Activity;
import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.view.ViewGroup;
import android.widget.Button;

import com.ms.remotecontroller.MainActivity;

public class RemoteController {
    private static final int Frequency = 38400;
    private static final int[] GaragePattern = {12000, 500};
    private static final int[] GatePattern = {12000, 500};

    Activity activity;
    ConsumerIrManager irManager;

    public RemoteController(MainActivity activity){
        this.activity = activity;
        irManager = (ConsumerIrManager)activity.getSystemService(Context.CONSUMER_IR_SERVICE);
    }

    public void Init(){

    }


    public Activity getActivity(){
        return activity;
    }


    public static Button createButton(Activity activity, String text){
        Button button = new Button(activity);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        button.setText(text);
        return button;
    }
}
