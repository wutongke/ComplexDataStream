package com.linked.erfli.complexstream.Adapter.TransformedItem;

import android.view.View;

import com.linked.erfli.complexstream.Model.BaseItem;
import com.linked.erfli.complexstream.Util.BackgroundLinearLayout;
import com.linked.erfli.complexstream.Util.ItemWrap;


/**
 * Created by erfli on 11/21/16.
 */

public abstract class BaseHolder implements BackgroundLinearLayout.OnPress {
    protected BaseItem baseItem;
    protected View itemView;

    public void setup(View view) {
        this.itemView = view;
    }

    public void render(BaseItem baseItem) {
        this.baseItem = baseItem;
    }

    @Override
    public void onStatePress(boolean pressed) {
        for (ItemWrap itemWrap : baseItem.itemWraps) {
            itemWrap.setPressed(pressed);
        }
    }
}
