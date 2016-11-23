package com.linked.erfli.complexstream.Model;

/**
 * Created by erfli on 11/21/16.
 */

public class HeaderTextItem extends BaseItem {
    private Header header;
    private String text;

    public HeaderTextItem(Header header, String text) {
        this.header = header;
        this.text = text;
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
}
