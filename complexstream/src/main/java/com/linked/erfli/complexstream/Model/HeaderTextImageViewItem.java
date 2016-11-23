package com.linked.erfli.complexstream.Model;

import java.util.List;

/**
 * Created by erfli on 11/21/16.
 */

public class HeaderTextImageViewItem extends BaseItem {
    private Header header;
    private String text;
    private List<String> images;

    public HeaderTextImageViewItem(Header header, String text, List<String> images) {
        this.header = header;
        this.text = text;
        this.images = images;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
