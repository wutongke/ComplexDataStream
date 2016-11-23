package com.linked.erfli.complexstream.Util;

import com.linked.erfli.complexstream.Model.BaseItem;

/**
 * Created by erfli on 11/21/16.
 */

public class ItemWrap {
    private BaseItem baseItem;

    public ItemWrap(BaseItem baseItem, ItemType itemType) {
        this.baseItem = baseItem;
        this.itemType = itemType;
    }

    private ItemType itemType;

    public BaseItem getBaseItem() {
        return baseItem;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
