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
import static org.mockito.Mockito.*;


/**
 *
 * @author Kanwar
 */
public class WarGameTest {
    
    public WarGameTest() {
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
    public void testPlayCardGood() {
        Player player = new Player("Alice");
        Card card = new Card(Card.Suit.HEARTS, Card.Rank.ACE);
        player.receiveCard(card);
        assertEquals(card, player.playCard());
    }

    /**
     * Test of playCard method when the player has no cards.
     */
    @Test
    public void testPlayCardBad() {
        Player player = new Player("Bob");
        assertNull(player.playCard());
    }

    /**
     * Test of playCard method boundary case with one card.
     */
    @Test
    public void testPlayCardBoundary() {
        Player player = new Player("Charlie");
        Card card = new Card(Card.Suit.CLUBS, Card.Rank.TWO);
        player.receiveCard(card);
        assertEquals(card, player.playCard());
        assertNull(player.playCard());
    }
}


    
  
}
