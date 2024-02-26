package com.example.top_trumps_start_code.models;

public enum Suit {

    SPADES(0, "&#x2660;"),
    HEARTS(1, "&#x2665;"),
    CLUBS(2, "&#x2663;"),
    DIAMONDS(3, "&#x2666;");

    private int index;
    private String emojiHex;

    Suit(int index, String emojiHex){
        this.index = index;
        this.emojiHex = emojiHex;
    }
    int getIndex() {return index;}

    String getEmojiHex() {return emojiHex;}

}
