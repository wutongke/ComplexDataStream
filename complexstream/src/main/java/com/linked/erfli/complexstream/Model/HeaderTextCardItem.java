package com.linked.erfli.complexstream.Model;

/**
 * Created by erfli on 11/21/16.
 */

public class HeaderTextCardItem extends BaseItem {
    private Header header;
    private String text;
    private Card card;

    public HeaderTextCardItem(Header header, String text, Card card) {
        this.header = header;
        this.text = text;
        this.card = card;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
