package com.ms.remotecontroller.fieldviews;

import android.view.View;

public interface FieldView<V extends View> {
    String getName();
    void setName(String name);

    Iterable<V> getViews();
    void addView(V View);
}
