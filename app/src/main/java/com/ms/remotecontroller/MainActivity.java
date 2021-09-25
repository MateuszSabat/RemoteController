package com.ms.remotecontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ms.remotecontroller.controller.serialization.ModelSerializer;
import com.ms.remotecontroller.model.Button;
import com.ms.remotecontroller.model.Controller;
import com.ms.remotecontroller.model.Field;
import com.ms.remotecontroller.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String CONTROLLER_SAVE = "controller.save";

    private ActivityMainBinding binding;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        controller = spawnController();
        controller.init(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ModelSerializer.serialize(this, controller, CONTROLLER_SAVE);
    }

    private Controller spawnController(){
        Controller controller = (Controller) ModelSerializer.deserialize(this, CONTROLLER_SAVE);
        if(controller != null) return controller;

        controller = new Controller();

        Field field1 = controller.addChild(new Field());
        Field field2 = controller.addChild(new Field());

        field1.addChild(new Button());
        field1.addChild(new Button());

        field2.addChild(new Button());
        field2.addChild(new Button());
        field2.addChild(new Button());
        field2.addChild(new Button());
        field2.addChild(new Button());

        return controller;
    }
}