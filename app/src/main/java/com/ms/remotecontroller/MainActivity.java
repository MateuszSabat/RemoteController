package com.ms.remotecontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ms.remotecontroller.model.Button;
import com.ms.remotecontroller.model.Controller;
import com.ms.remotecontroller.model.Field;
import com.ms.remotecontroller.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private LinearLayout baseLayout;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        baseLayout = findViewById(R.id.base_layout);

        controller = new Controller();
        controller.init(this);

        Field field1 = controller.addChild(new Field());
        Field field2 = controller.addChild(new Field());

        field1.addChild(new Button());
        field1.addChild(new Button());

        field2.addChild(new Button());
        field2.addChild(new Button());
        field2.addChild(new Button());
        field2.addChild(new Button());
        field2.addChild(new Button());
        field2.addChild(new Button());
        field2.addChild(new Button());
    }

    public ViewGroup getMainGroup(){
        return baseLayout;
    }
}