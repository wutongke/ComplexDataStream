package com.linked.erfli.complexstream.Model;

/**
 * Created by erfli on 11/21/16.
 */

public class HeaderCardItem extends BaseItem {
    private Header header;
    private Card card;

    public HeaderCardItem(Header header, Card card) {
        this.header = header;
        this.card = card;
    }

    public Header getHeader() {

        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
