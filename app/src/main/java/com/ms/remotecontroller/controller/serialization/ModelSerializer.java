package com.ms.remotecontroller.controller.serialization;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.ms.remotecontroller.model.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ModelSerializer {
    public static void serialize(Activity context, Model model, String path){
        try (ObjectOutputStream stream = new ObjectOutputStream(context.openFileOutput(path, Context.MODE_PRIVATE))){
            stream.writeObject(model);
            stream.flush();
        } catch (IOException e) {
            Log.e("EXC_SER", e.getLocalizedMessage());
        }
    }
    public static Model deserialize(Activity context, String path){
        try(ObjectInputStream stream = new ObjectInputStream(context.openFileInput(path))){
            Model model =  (Model) stream.readObject();
            return model;
        } catch (IOException | ClassNotFoundException e) {
            Log.e("EXC_DES", e.getLocalizedMessage());
        }
        return null;
    }
}
