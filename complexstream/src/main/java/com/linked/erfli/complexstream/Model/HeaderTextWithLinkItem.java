package com.linked.erfli.complexstream.Model;

/**
 * Created by erfli on 11/21/16.
 */

public class HeaderTextWithLinkItem extends BaseItem{
    private Header header;
    private String text;
    private String link;

    public HeaderTextWithLinkItem(Header header, String text, String link) {
        this.header = header;
        this.text = text;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
