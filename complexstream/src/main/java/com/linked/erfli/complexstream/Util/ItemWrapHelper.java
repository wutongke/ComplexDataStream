package com.linked.erfli.complexstream.Util;

import android.view.LayoutInflater;
import android.view.View;

import com.linked.complexstream.R;
import com.linked.erfli.complexstream.Adapter.TransformedItem.BaseHolder;
import com.linked.erfli.complexstream.Adapter.TransformedItem.CardHolder;
import com.linked.erfli.complexstream.Adapter.TransformedItem.DividerHolder;
import com.linked.erfli.complexstream.Adapter.TransformedItem.HeaderHolder;
import com.linked.erfli.complexstream.Adapter.TransformedItem.ImageHolder;
import com.linked.erfli.complexstream.Adapter.TransformedItem.LinkHolder;
import com.linked.erfli.complexstream.Adapter.TransformedItem.TextHolder;
import com.linked.erfli.complexstream.Adapter.TransformedItem.TitleHolder;
import com.linked.erfli.complexstream.Model.BaseItem;
import com.linked.erfli.complexstream.Model.CardWithTitleItem;
import com.linked.erfli.complexstream.Model.HeaderCardItem;
import com.linked.erfli.complexstream.Model.HeaderImageCardItem;
import com.linked.erfli.complexstream.Model.HeaderImageItem;
import com.linked.erfli.complexstream.Model.HeaderTextCardItem;
import com.linked.erfli.complexstream.Model.HeaderTextImageViewItem;
import com.linked.erfli.complexstream.Model.HeaderTextItem;
import com.linked.erfli.complexstream.Model.HeaderTextWithLinkItem;
import com.linked.erfli.complexstream.Model.HeaderTextWithTitleItem;
import com.linked.erfli.complexstream._Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erfli on 11/21/16.
 */

public class ItemWrapHelper {


    private static Map<Class, List<ItemType>> map = new HashMap<>();

    static {
        List<ItemType> cardWithTitleItemList = new ArrayList<>();
        cardWithTitleItemList.add(ItemType.TITLE);
        cardWithTitleItemList.add(ItemType.CARD);
        map.put(CardWithTitleItem.class, cardWithTitleItemList);

        List<ItemType> headerCardItemList = new ArrayList<>();
        headerCardItemList.add(ItemType.HEADER);
        headerCardItemList.add(ItemType.CARD);
        map.put(HeaderCardItem.class, headerCardItemList);

        List<ItemType> headerImageCardItemList = new ArrayList<>();
        headerImageCardItemList.add(ItemType.HEADER);
        headerImageCardItemList.add(ItemType.IMAGE);
        headerImageCardItemList.add(ItemType.CARD);
        map.put(HeaderImageCardItem.class, headerImageCardItemList);

        List<ItemType> headerImageItemList = new ArrayList<>();
        headerImageItemList.add(ItemType.HEADER);
        headerImageItemList.add(ItemType.IMAGE);
        map.put(HeaderImageItem.class, headerImageItemList);

        List<ItemType> headerTextCardItemList = new ArrayList<>();
        headerTextCardItemList.add(ItemType.HEADER);
        headerTextCardItemList.add(ItemType.TEXT);
        headerTextCardItemList.add(ItemType.CARD);
        map.put(HeaderTextCardItem.class, headerTextCardItemList);

        List<ItemType> headerTextImageViewItemList = new ArrayList<>();
        headerTextImageViewItemList.add(ItemType.HEADER);
        headerTextImageViewItemList.add(ItemType.TEXT);
        headerTextImageViewItemList.add(ItemType.IMAGE);
        map.put(HeaderTextImageViewItem.class, headerTextImageViewItemList);

        List<ItemType> headerTextItemList = new ArrayList<>();
        headerTextItemList.add(ItemType.HEADER);
        headerTextItemList.add(ItemType.TEXT);
        map.put(HeaderTextItem.class, headerTextItemList);

        List<ItemType> headerTextWithLinkItemList = new ArrayList<>();
        headerTextWithLinkItemList.add(ItemType.HEADER);
        headerTextWithLinkItemList.add(ItemType.TEXT);
        headerTextWithLinkItemList.add(ItemType.LINK);
        map.put(HeaderTextWithLinkItem.class, headerTextWithLinkItemList);

        List<ItemType> headerTextWithTitleItemList = new ArrayList<>();
        headerTextWithTitleItemList.add(ItemType.TITLE);
        headerTextWithTitleItemList.add(ItemType.HEADER);
        headerTextWithTitleItemList.add(ItemType.TEXT);
        map.put(HeaderTextWithTitleItem.class, headerTextWithTitleItemList);
    }

    public static List<ItemWrap> getTransformedItem(List<BaseItem> baseItems) {
        List<ItemWrap> itemWraps = new ArrayList<>();
        for (BaseItem baseItem : baseItems) {
            for (ItemType itemType : map.get(baseItem.getClass())) {
                ItemWrap temp = new ItemWrap(baseItem, itemType);
                itemWraps.add(temp);
                baseItem.itemWraps.add(temp);
            }
            ItemWrap divider = new ItemWrap(baseItem, ItemType.DIVIDER);
            itemWraps.add(divider);
            baseItem.itemWraps.add(divider);
        }
        return itemWraps;
    }

    public static View getItemView(ItemType itemType){
        BackgroundLinearLayout layout = (BackgroundLinearLayout) LayoutInflater.from(_Application.applicationContext).inflate(R.layout.item_layout, null);
        View contentView = createItemView(itemType);
        layout.addView(contentView);
        BaseHolder baseHolder = (BaseHolder) contentView.getTag();
        layout.setTag(baseHolder);
        layout.setOnPressListener(baseHolder);
        return layout;
    }

    public static View createItemView(ItemType itemType) {
        View view = null;
        BaseHolder baseHolder = null;
        switch (itemType) {
            case TITLE:
                view = LayoutInflater.from(_Application.applicationContext).inflate(R.layout.title_item, null);
                baseHolder = new TitleHolder();
                break;
            case CARD:
                view = LayoutInflater.from(_Application.applicationContext).inflate(R.layout.card_item, null);
                baseHolder = new CardHolder();
                break;
            case TEXT:
                view = LayoutInflater.from(_Application.applicationContext).inflate(R.layout.text_item, null);
                baseHolder = new TextHolder();
                break;
            case IMAGE:
                view = LayoutInflater.from(_Application.applicationContext).inflate(R.layout.image_item, null);
                baseHolder = new ImageHolder();
                break;
            case LINK:
                view = LayoutInflater.from(_Application.applicationContext).inflate(R.layout.link_item, null);
                baseHolder = new LinkHolder();
                break;
            case HEADER:
                view = LayoutInflater.from(_Application.applicationContext).inflate(R.layout.header_item, null);
                baseHolder = new HeaderHolder();
                break;
            case DIVIDER:
                view = LayoutInflater.from(_Application.applicationContext).inflate(R.layout.divider_item, null);
                baseHolder = new DividerHolder();
                break;
        }
        baseHolder.setup(view);
        view.setTag(baseHolder);
        return view;
    }
}
