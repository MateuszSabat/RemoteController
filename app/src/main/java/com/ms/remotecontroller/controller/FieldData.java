package com.ms.remotecontroller.controller;

import java.util.ArrayList;

public class FieldData {
    private String name;
    private ArrayList<ButtonData> buttons;

    public String getName(){
        return name;
    }
    public Iterable<ButtonData> getButtons(){
        return buttons;
    }
}

