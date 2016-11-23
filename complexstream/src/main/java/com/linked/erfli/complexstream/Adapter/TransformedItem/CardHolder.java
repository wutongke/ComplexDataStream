package com.linked.erfli.complexstream.Adapter.TransformedItem;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.bumptech.glide.Glide;
import com.linked.complexstream.R;
import com.linked.complexstream.databinding.CardItemBinding;
import com.linked.erfli.complexstream.Model.BaseItem;
import com.linked.erfli.complexstream.Model.Card;
import com.linked.erfli.complexstream.Model.CardWithTitleItem;
import com.linked.erfli.complexstream.Model.HeaderCardItem;
import com.linked.erfli.complexstream.Model.HeaderImageCardItem;
import com.linked.erfli.complexstream.Model.HeaderTextCardItem;

/**
 * Created by erfli on 11/21/16.
 */

public class CardHolder extends BaseHolder {
    CardItemBinding cardItemBinding;

    @Override
    public void setup(View view) {
        super.setup(view);
        cardItemBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void render(BaseItem baseItem) {
        super.render(baseItem);
        Card card = null;
        if(baseItem instanceof CardWithTitleItem){
            card = ((CardWithTitleItem) baseItem).getCard();
        }else if(baseItem instanceof HeaderCardItem){
            card = ((HeaderCardItem) baseItem).getCard();
        }else if(baseItem instanceof HeaderImageCardItem){
            card = ((HeaderImageCardItem) baseItem).getCard();
        }else if(baseItem instanceof HeaderTextCardItem){
            card = ((HeaderTextCardItem) baseItem).getCard();
        }
        Glide.clear(cardItemBinding.cardImage);
        Glide.with(itemView.getContext())
                .load(card.getImage())
                .placeholder(R.drawable.pictures)
                .into(cardItemBinding.cardImage);
        cardItemBinding.cardText.setText(card.getText());
    }
}
