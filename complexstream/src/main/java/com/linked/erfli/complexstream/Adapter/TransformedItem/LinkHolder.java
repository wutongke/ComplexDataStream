package com.linked.erfli.complexstream.Adapter.TransformedItem;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.linked.complexstream.databinding.LinkItemBinding;
import com.linked.erfli.complexstream.Model.BaseItem;
import com.linked.erfli.complexstream.Model.HeaderTextWithLinkItem;

/**
 * Created by erfli on 11/21/16.
 */

public class LinkHolder extends BaseHolder {
    LinkItemBinding linkItemBinding;
    @Override
    public void setup(View view) {
        super.setup(view);
        linkItemBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void render(BaseItem baseItem) {
        if(baseItem instanceof HeaderTextWithLinkItem){
            linkItemBinding.linkText.setText(((HeaderTextWithLinkItem) baseItem).getLink());
        }
    }
}
