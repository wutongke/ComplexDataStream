package com.linked.erfli.complexstream.Adapter.TransformedItem;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.linked.complexstream.databinding.TextItemBinding;
import com.linked.erfli.complexstream.Model.BaseItem;
import com.linked.erfli.complexstream.Model.HeaderTextCardItem;
import com.linked.erfli.complexstream.Model.HeaderTextImageViewItem;
import com.linked.erfli.complexstream.Model.HeaderTextItem;
import com.linked.erfli.complexstream.Model.HeaderTextWithLinkItem;
import com.linked.erfli.complexstream.Model.HeaderTextWithTitleItem;

/**
 * Created by erfli on 11/21/16.
 */

public class TextHolder extends BaseHolder {
    TextItemBinding textItemBinding;
    @Override
    public void setup(View view) {
        super.setup(view);
        textItemBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void render(BaseItem baseItem) {
        String text = "";
        if(baseItem instanceof HeaderTextCardItem){
            text = ((HeaderTextCardItem) baseItem).getText();
        }else if(baseItem instanceof HeaderTextImageViewItem){
            text = ((HeaderTextImageViewItem) baseItem).getText();
        }else if(baseItem instanceof HeaderTextItem){
            text = ((HeaderTextItem) baseItem).getText();
        }else if(baseItem instanceof HeaderTextWithLinkItem){
            text = ((HeaderTextWithLinkItem) baseItem).getText();
        }else if(baseItem instanceof HeaderTextWithTitleItem){
            text = ((HeaderTextWithTitleItem) baseItem).getText();
        }
        textItemBinding.contentText.setText(text);
    }
}
