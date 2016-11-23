package com.linked.erfli.complexstream.Model;

/**
 * Created by erfli on 11/21/16.
 */

public class CardWithTitleItem extends BaseItem {
    private String title;

    public CardWithTitleItem(String title, Card card) {
        this.title = title;
        this.card = card;
    }

    private Card card;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
