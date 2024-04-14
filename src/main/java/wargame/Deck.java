/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wargame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a deck of playing cards.
 * Each deck contains a standard set of 52 cards (4 suits, 13 values per suit).
 * Cards are shuffled upon initialization.
 * @author Kanwarpreet Kaur
 * @author Rajmohinder Kaur
 */
public class Deck {
    private List<Card> cards;

    /**
     * Constructs a new Deck containing a standard set of 52 cards.
     * The cards are shuffled upon initialization.
     */
    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) {
                cards.add(new Card(suit, i));
            }
        }
        shuffle();
    }

    /**
     * Shuffles the deck of cards.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

   /**
    * Draws a card from the deck.
    * 
    * @return the card drawn from the deck, or null if the deck is empty
    */
   public Card drawCard() {
       if (cards.isEmpty()) {
           return null;
       }
       return cards.remove(cards.size() - 1);
   }



    /**
     * Checks if the deck is empty.
     * 
     * @return true if the deck is empty, false otherwise
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

}
