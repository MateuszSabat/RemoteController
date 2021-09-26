package com.ms.remotecontroller.view.action;

import android.app.Activity;
import android.widget.TextView;

import com.ms.remotecontroller.view.base.FieldView;

public class ActionFieldView extends FieldView {
    @Override
    protected TextView createNameView(Activity activity) {
        return new TextView(activity);
    }
}
