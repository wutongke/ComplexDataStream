package com.linked.erfli.complexstream.Model;

/**
 * Created by erfli on 11/21/16.
 */

public class Card {
    private String Image;
    private String Text;

    public Card(String image, String text) {
        Image = image;
        Text = text;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
