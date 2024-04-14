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
public class PlayerTest {
    
    public PlayerTest() {
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

    /**
     * Test of playCard method, of class Player.
     */
    @Test
    public void testPlayCardGood() {
        Player instance = new Player("Alice");
        Card card = new Card(Card.Suit.HEARTS, Card.Rank.ACE);
        instance.receiveCard(card);
        assertNotNull(instance.playCard());
    }

    @Test
    public void testPlayCardBad() {
        Player instance = new Player("Bob");
        assertNull(instance.playCard());
    }

    @Test
    public void testPlayCardBoundary() {
        Player instance = new Player("Charlie");
        Card card = new Card(Card.Suit.HEARTS, Card.Rank.ACE);
        instance.receiveCard(card);
        instance.playCard();
        assertNull(instance.playCard());
    }

    /**
     * Test of hasCards method, of class Player.
     */
    @Test
    public void testHasCardsGood() {
        Player instance = new Player("Alice");
        Card card = new Card(Card.Suit.HEARTS, Card.Rank.ACE);
        instance.receiveCard(card);
        assertTrue(instance.hasCards());
    }

    @Test
    public void testHasCardsBad() {
        Player instance = new Player("Bob");
        assertFalse(instance.hasCards());
    }

    @Test
    public void testHasCardsBoundary() {
        Player instance = new Player("Charlie");
        assertFalse(instance.hasCards());
        Card card = new Card(Card.HEARTS, Card.Rank.ACE);
        instance.receiveCard(card);
        assertTrue(instance.hasCards());
    }

    /**
     * Test of setName method, of class Player.
     */
    @Test
    public void testSetNameGood() {
        Player instance = new Player("Alice");
        String newName = "Bob";
        instance.setName(newName);
        assertEquals(newName, instance.getName());
    }

    @Test
    public void testSetNameBad() {
        Player instance = new Player("Charlie");
        String newName = "Charlie";
        instance.setName(newName);
        assertEquals("Charlie", instance.getName());
    }

    @Test
    public void testSetNameBoundary() {
        Player instance = new Player("Alice");
        String newName = "";
        instance.setName(newName);
        assertEquals("", instance.getName());
    }
}
