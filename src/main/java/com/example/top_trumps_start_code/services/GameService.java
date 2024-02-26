package com.example.top_trumps_start_code.services;

import com.example.top_trumps_start_code.models.Card;
import com.example.top_trumps_start_code.models.Deck;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService {

    private Deck deck;

    public String newGame(){
        deck = new Deck();
        return "New game created!";
    }

    public String checkWinner(ArrayList<Card> cards){

        // Create card objects
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);

        // Check if card deck has been created
        if(this.deck == null){
            return "The card deck has not been initialised.";
        }

        // Check if either of the cards have already been drawn
        if(!(deck.cardInDeck(card1))){
            return card1.getCardValue() + " of " + card1.getSuit() + " is no longer in the deck.\n" +
                    "Please see the available cards listed below:\n\n" + deck.remainingCards();
        }
        if(!(deck.cardInDeck(card2))){
            return card2.getCardValue() + " of " + card2.getSuit() + " is no longer in the deck.\n" +
                    "Please see the available cards listed below:\n\n" + deck.remainingCards();
        }

        // Remove these cards from the deck
        deck.removeCard(card1);
        deck.removeCard(card2);

        // Could check for spelling mistakes here

        if(card1.getCardValue() > card2.getCardValue()){
            return String.format("%s of %s is the winner!", card1.getRank(), card1.getSuit());
        }else if(card2.getCardValue() > card1.getCardValue()){
            return String.format("%s of %s is the winner!", card2.getRank(), card2.getSuit());
        }else{
            return "It's a draw!";
        }
    }

    public Deck getDeck() {
        return deck;
    }
    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
