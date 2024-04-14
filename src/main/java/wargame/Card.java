/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wargame;

/**
 * Represents a playing card in a card game.
 * Each card has a suit and a value.
 * 
 * @author Kanwarpreet Kaur
 * @author Rajmohinder Kaur
 */
public class Card {
    private String suit;
    private int value;

    /**
     * Constructs a new Card with the given suit and value.
     * 
     * @param suit  the suit of the card (e.g., Hearts, Diamonds, etc.)
     * @param value the value of the card (e.g., 2 for Two, 10 for Ten, etc.)
     */
    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * Gets the value of the card.
     * 
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the suit of the card.
     * 
     * @param suit the new suit to set
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

    /**
     * Gets the suit of the card.
     * 
     * @return the suit of the card
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Returns a string representation of the card.
     * 
     * @return a string representation of the card
     */
    @Override
    public String toString() {
        return suit + " " + value;
    }
}