package com.linked.erfli.complexstream.Adapter.TransformedItem;

import android.view.View;

import com.linked.erfli.complexstream.Model.BaseItem;


/**
 * Created by erfli on 11/21/16.
 */

public abstract class BaseHolder {
    protected BaseItem baseItem;
    protected View itemView;

    public void setup(View view) {
        this.itemView = view;
    }

    public abstract void render(BaseItem baseItem);

}
