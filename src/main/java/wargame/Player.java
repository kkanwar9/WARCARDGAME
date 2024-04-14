package wargame;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a player in a card game.
 * Each player has a name and a hand of cards.
 * Players can receive cards, play cards, and check if they have cards in their hand.
 * This class also provides a method to edit the name of the player.
 * 
 * @author Kanwarpreet Kaur
 * @author Rajmohinder Kaur
 */
public class Player {
    private Queue<Card> hand = new LinkedList<>();
    private String name;

    /**
     * Constructs a new Player with the given name.
     * 
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Receives a card and adds it to the player's hand.
     * 
     * @param faceUpCards the card to receive
     */
    /**
     * Receives an array of cards and adds them to the player's hand.
     * 
     * @param card2 the array of cards to receive
     */
    


    /**
     * Plays a card from the player's hand.
     * If the player's hand is empty, returns null.
     * 
     * @return the card played, or null if the hand is empty
     */
    public Card playCard() {
        if (!hand.isEmpty()) {
            return hand.poll();
        } else {
            return null;
        }
    }


    /**
     * Checks if the player has cards in their hand.
     * 
     * @return true if the player has cards, false otherwise
     */
    public boolean hasCards() {
        return !hand.isEmpty();
    }

    /**
     * Gets the name of the player.
     * 
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the player.
     * 
     * @param name the new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Displays the player's hand.
     * 
     * @return a string representation of the player's hand
     */
    public String displayHand() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player ").append(name).append("'s Hand: [");
        for (Card card : hand) {
            sb.append(card.toString()).append(", ");
        }
        if (!hand.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Gets the size of the player's hand.
     *
     * @return the number of cards in the player's hand
     */
    public int getHandSize() {
        return hand.size();
    }

    /**
     * Checks if the player has enough cards to participate in a war.
     *
     * @return true if the player has at least 4 cards, false otherwise
     */
    public boolean hasEnoughCardsForWar() {
        return hand.size() >= 4;
    }
    
    /**
     * Edits the name of the player.
     * 
     * @param newName the new name of the player
     */
    public void edit(String newName) {
        this.name = newName;
    }

    public void receiveCard(Card card) {
        if (card != null) {
            hand.add(card);
        }
    }

}

