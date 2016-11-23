package com.linked.erfli.complexstream.Adapter.TransformedItem;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.bumptech.glide.Glide;
import com.linked.complexstream.R;
import com.linked.complexstream.databinding.HeaderItemBinding;
import com.linked.erfli.complexstream.Model.BaseItem;
import com.linked.erfli.complexstream.Model.Header;
import com.linked.erfli.complexstream.Model.HeaderCardItem;
import com.linked.erfli.complexstream.Model.HeaderImageCardItem;
import com.linked.erfli.complexstream.Model.HeaderImageItem;
import com.linked.erfli.complexstream.Model.HeaderTextCardItem;
import com.linked.erfli.complexstream.Model.HeaderTextImageViewItem;
import com.linked.erfli.complexstream.Model.HeaderTextItem;
import com.linked.erfli.complexstream.Model.HeaderTextWithLinkItem;
import com.linked.erfli.complexstream.Model.HeaderTextWithTitleItem;

/**
 * Created by erfli on 11/21/16.
 */

public class HeaderHolder extends BaseHolder {
    HeaderItemBinding headerItemBinding;

    @Override
    public void setup(View view) {
        super.setup(view);
        headerItemBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void render(BaseItem baseItem) {
        super.render(baseItem);
        Header header = null;
        if (baseItem instanceof HeaderCardItem) {
            header = ((HeaderCardItem) baseItem).getHeader();
        } else if (baseItem instanceof HeaderImageCardItem) {
            header = ((HeaderImageCardItem) baseItem).getHeader();
        } else if (baseItem instanceof HeaderTextCardItem) {
            header = ((HeaderTextCardItem) baseItem).getHeader();
        } else if (baseItem instanceof HeaderTextImageViewItem) {
            header = ((HeaderTextImageViewItem) baseItem).getHeader();
        } else if (baseItem instanceof HeaderTextItem) {
            header = ((HeaderTextItem) baseItem).getHeader();
        } else if (baseItem instanceof HeaderTextWithLinkItem) {
            header = ((HeaderTextWithLinkItem) baseItem).getHeader();
        } else if (baseItem instanceof HeaderTextWithTitleItem) {
            header = ((HeaderTextWithTitleItem) baseItem).getHeader();
        }else if(baseItem instanceof HeaderImageItem){
            header = ((HeaderImageItem) baseItem).getHeader();
        }
        headerItemBinding.name.setText(header.getName());
        headerItemBinding.age.setText(header.getAge() + "");
        Glide.clear(headerItemBinding.avatar);
        Glide.with(headerItemBinding.avatar.getContext())
                .load(header.getAvatar())
                .placeholder(R.drawable.person)
                .into(headerItemBinding.avatar);
    }
}
