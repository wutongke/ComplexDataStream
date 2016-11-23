package com.linked.erfli.complexstream.Model;

import java.util.List;

/**
 * Created by erfli on 11/21/16.
 */

public class HeaderImageCardItem extends BaseItem {
    private Header header;

    public HeaderImageCardItem(Header header, List<String> images, Card card) {
        this.header = header;
        this.images = images;
        this.card = card;
    }

    public List<String> getImages() {

        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    private List<String> images;
    private Card card;

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
