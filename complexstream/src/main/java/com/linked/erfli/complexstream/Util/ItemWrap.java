package com.linked.erfli.complexstream.Util;

import android.view.View;

import com.linked.erfli.complexstream.Model.BaseItem;

/**
 * Created by erfli on 11/21/16.
 */

public class ItemWrap {
    private BaseItem baseItem;
    private View bindView;

    public ItemWrap(BaseItem baseItem, ItemType itemType) {
        this.baseItem = baseItem;
        this.itemType = itemType;
    }

    public void bindView(View view) {
        this.bindView = view;
    }

    public void unBindView() {
        this.bindView = null;
    }

    public void setPressed(boolean pressed) {
        if (bindView != null)
            bindView.setPressed(pressed);
    }

    private ItemType itemType;

    public BaseItem getBaseItem() {
        return baseItem;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
