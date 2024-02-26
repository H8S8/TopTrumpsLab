package com.example.top_trumps_start_code.models;


import java.util.ArrayList;
import java.util.Arrays;

public class Deck {

    Boolean[][] cardDeck;

    public Deck() {
        this.cardDeck = new Boolean[4][14];

        for(int i = 0; i < 4; i++){
            Arrays.fill(this.cardDeck[i], true);
        }
    }

    public boolean deckNotEmpty(){

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){

                if(this.cardDeck[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cardInDeck(Card card){
        return cardDeck[card.getSuitIndex()][card.getCardValue() - 2];
    }

    public String remainingCards(){

        String output = "";

        for(Suit suit: Suit.values()){
            output += suit + ": ";

            for(Rank rank: Rank.values()) {
                if (this.cardDeck[suit.getIndex()][rank.getValue() - 2]) {
                    output += rank + ", ";
                }
            }
            output += "\n";
        }

        return output;
    }

    public void removeCard(Card card){
        this.cardDeck[card.getSuitIndex()][card.getCardValue() - 2] = false;
    }

    public Boolean[][] getCardDeck() {
        return cardDeck;
    }
    public void setCardDeck(Boolean[][] cardDeck) {
        this.cardDeck = cardDeck;
    }
}
