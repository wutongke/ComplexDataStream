package com.linked.erfli.complexstream.Model;

import java.util.List;

/**
 * Created by erfli on 11/21/16.
 */

public class HeaderImageItem extends BaseItem {
    public HeaderImageItem(Header header, List<String> images) {
        this.header = header;
        this.images = images;
    }

    private Header header;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    private List<String> images;
}
