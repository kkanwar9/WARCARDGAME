/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package wargame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kanwar
 */
public class DeckTest {
    
    public DeckTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
   @Test
    public void testConstructorAndDrawCardGood() {
        Deck deck = new Deck();
        assertFalse(deck.isEmpty()); // Deck should not be empty after initialization
        for (int i = 0; i < 52; i++) {
            assertNotNull(deck.drawCard()); // Drawing a card should not return null until the deck is empty
        }
        assertTrue(deck.isEmpty()); // Deck should be empty after drawing all cards
        assertNull(deck.drawCard()); // Drawing from an empty deck should return null
    }

    @Test
    public void testConstructorAndDrawCardBad() {
        // Test constructor with a negative number of cards
        assertThrows(IllegalArgumentException.class, () -> {
            Deck deck = new Deck(-3);
        });

        // Test drawCard from an empty deck
        Deck deck = new Deck(-1);
        for (int i = 0; i < 52; i++) {
            deck.drawCard();
        }
        assertNull(deck.drawCard());
    }



    @Test
    public void testConstructorAndDrawCardBoundary() {
        // Test constructor with 0 cards
        assertThrows(IllegalArgumentException.class, () -> {
            Deck deck = new Deck(0);
        });

        // Test constructor with 1 card
        Deck deck = new Deck(1);
        assertFalse(deck.isEmpty());
        assertNotNull(deck.drawCard());
        assertTrue(deck.isEmpty());
        assertNull(deck.drawCard());
    }

    @Test
    public void testShuffleGood() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        // Shuffle both decks
        deck1.shuffle();
        deck2.shuffle();
        // Ensure that the order of cards in the two decks is not the same
        assertNotEquals(deck1, deck2);
    }

    @Test
    public void testShuffleBad() {
        // Test shuffle with an empty deck
        Deck emptyDeck = new Deck();
        emptyDeck.drawCard(); // Empty the deck
        assertThrows(IllegalStateException.class, () -> {
            emptyDeck.shuffle();
        });
    }

    @Test
    public void testShuffleBoundary() {
        // Test shuffle with a single card deck
        Deck singleCardDeck = new Deck(1);
        assertDoesNotThrow(() -> {
            singleCardDeck.shuffle();
        });
        assertTrue(singleCardDeck.isEmpty());
    }
    
   }
