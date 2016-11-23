package com.linked.erfli.complexstream.Adapter.TransformedItem;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.linked.complexstream.databinding.TitleItemBinding;
import com.linked.erfli.complexstream.Model.BaseItem;
import com.linked.erfli.complexstream.Model.CardWithTitleItem;
import com.linked.erfli.complexstream.Model.HeaderTextWithTitleItem;

/**
 * Created by erfli on 11/21/16.
 */

public class TitleHolder extends BaseHolder {
    TitleItemBinding titleItemBinding;

    @Override
    public void setup(View view) {
        super.setup(view);
        titleItemBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void render(BaseItem baseItem) {
        if (baseItem instanceof HeaderTextWithTitleItem) {
            titleItemBinding.titleText.setText(((HeaderTextWithTitleItem) baseItem).getTitle());
        }else if(baseItem instanceof CardWithTitleItem){
            titleItemBinding.titleText.setText(((CardWithTitleItem) baseItem).getTitle());
        }
    }
}
