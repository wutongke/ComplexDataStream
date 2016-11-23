package com.linked.erfli.complexstream.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.linked.erfli.complexstream.Adapter.TransformedItem.BaseHolder;
import com.linked.erfli.complexstream.Util.ItemType;
import com.linked.erfli.complexstream.Util.ItemWrap;
import com.linked.erfli.complexstream.Util.ItemWrapHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erfli on 11/21/16.
 */

public class ComplexStreamAdapter extends BaseAdapter {

    private List<ItemWrap> transformedItemList = new ArrayList<>();

    public void setTransformedItemList(List<ItemWrap> transformedItemList) {
        this.transformedItemList = transformedItemList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return transformedItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return transformedItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return ((ItemWrap)getItem(position)).getItemType().ordinal();
    }

    @Override
    public int getViewTypeCount() {
        return ItemType.values().length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemWrap itemWrap = (ItemWrap) getItem(position);
        if(convertView == null){
            convertView = ItemWrapHelper.createItemView(itemWrap.getItemType());
        }
        BaseHolder baseHolder = (BaseHolder) convertView.getTag();
        baseHolder.render(itemWrap.getBaseItem());
        return convertView;
    }
}
