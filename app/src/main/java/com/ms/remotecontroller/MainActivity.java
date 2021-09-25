package com.ms.remotecontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ms.remotecontroller.controller.RemoteController;
import com.ms.remotecontroller.databinding.ActivityMainBinding;
import com.ms.remotecontroller.fieldviews.FieldView;
import com.ms.remotecontroller.fieldviews.GridFieldView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private LinearLayout baseLayout;
    private RemoteController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        baseLayout = findViewById(R.id.base_layout);

        controller = new RemoteController(this);
        controller.Init();

        FieldView<Button> buttonField = new GridFieldView<Button>(this, baseLayout, 3, "TEST");
        buttonField.addView(RemoteController.createButton(this, "Test 1"));
        buttonField.addView(RemoteController.createButton(this, "Test 2"));
        buttonField.addView(RemoteController.createButton(this, "Test 3"));
        buttonField.addView(RemoteController.createButton(this, "Test 4"));
        buttonField.addView(RemoteController.createButton(this, "Test 5"));
    }

    public ViewGroup getMainGroup(){
        return baseLayout;
    }
}