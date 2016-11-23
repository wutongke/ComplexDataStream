package com.linked.erfli.complexstream.Model;

/**
 * Created by erfli on 11/21/16.
 */

public class HeaderTextWithTitleItem extends BaseItem{
    private Header header;
    private String text;
    private String title;

    public HeaderTextWithTitleItem(Header header, String text, String title) {
        this.header = header;
        this.text = text;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
