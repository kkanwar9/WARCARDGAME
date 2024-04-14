package wargame;

import java.util.Scanner;

public class WarGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        // Prompt for player names
        System.out.println("Welcome to the War Card Game!");
        System.out.println("Enter the number of players: ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Player[] players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter Player " + (i + 1) + " name: ");
            String playerName = scanner.nextLine();
            players[i] = new Player(playerName);
        }

        // Distribute cards to players
        System.out.println("Shuffling the cards...");
        deck.shuffle();
        System.out.println("Distributing the cards...");
        for (int i = 0; i < 52; i++) {
            players[i % numberOfPlayers].receiveCard(deck.drawCard());
        }

        // Play game
        System.out.println("Game starts!!");
        int round = 0;
        Player roundWinner = null;
        while (true) {
            round++;

            System.out.println("Round " + round);
            for (Player player : players) {
                if (!player.hasCards()) continue;

                Card card = player.playCard();
                System.out.println(player.getName() + " got " + card);
            }

            // Determine the winner of the round
            roundWinner = determineRoundWinner(players);
            if (roundWinner != null) {
                System.out.println(roundWinner.getName() + " is the winner");
            } else {
                System.out.println("Round is a tie! War begins...");
                handleWar(players);
            }

            // Check if any player has run out of cards
            Player outOfCardsPlayer = null;
            for (Player player : players) {
                if (!player.hasCards()) {
                    outOfCardsPlayer = player;
                    break;
                }
            }

            if (outOfCardsPlayer != null) {
                System.out.println(outOfCardsPlayer.getName() + " has run out of cards! Game over after total " + round + " rounds!");
                break;
            }

            // Check if any player has all the cards
            Player allCardsPlayer = null;
            for (Player player : players) {
                if (player.getHandSize() == 52) {
                    allCardsPlayer = player;
                    break;
                }
            }

            if (allCardsPlayer != null) {
                System.out.println(allCardsPlayer.getName() + " has all the cards! Game over after total " + round + " rounds!");
                break;
            }
        }

        scanner.close();
    }

    /**
     * Determines the winner of the round.
     *
     * @param players The array of players.
     * @return The player who won the round.
     */
    private static Player determineRoundWinner(Player[] players) {
        Card[] cards = new Card[players.length];
        for (int i = 0; i < players.length; i++) {
            cards[i] = players[i].playCard();
        }

        // Compare the cards to determine the winner
        int maxIndex = 0;
        for (int i = 1; i < cards.length; i++) {
            if (cards[i] != null && (cards[maxIndex] == null || cards[i].getValue() > cards[maxIndex].getValue())) {
                maxIndex = i;
            }
        }

        int maxCount = 0;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null && cards[i].getValue() == cards[maxIndex].getValue()) {
                maxCount++;
            }
        }

        if (maxCount > 1) {
            return null; // Tie
        } else {
            return players[maxIndex];
        }
    }

    /**
     * Handles the war scenario when there's a tie.
     *
     * @param players The array of players.
     */
    private static void handleWar(Player[] players) {
        System.out.println("Round is a tie! War begins...");
        Card[] faceUpCards = new Card[players.length]; // Store face-up cards
        for (int i = 0; i < players.length; i++) {
            if (players[i].hasEnoughCardsForWar()) {
                faceUpCards[i] = players[i].playCard(); // Draw face-up card
                System.out.println(players[i].getName() + " draws 3 cards face down and one card face up: " + faceUpCards[i]);
            }
        }

        // Determine the player with the highest face-up card
        int maxIndex = 0;
        for (int i = 1; i < players.length; i++) {
            if (faceUpCards[i] != null && (faceUpCards[maxIndex] == null || faceUpCards[i].getValue() > faceUpCards[maxIndex].getValue())) {
                maxIndex = i;
            }
        }

        // Check if there's a tie in the face-up cards
        int tieCount = 0;
        for (int i = 0; i < players.length; i++) {
            if (faceUpCards[i] != null && faceUpCards[i].getValue() == faceUpCards[maxIndex].getValue()) {
                tieCount++;
            }
        }

        if (tieCount > 1) {
            System.out.println("War!");
            // Implement war logic if needed
        } else {
            // Give each face-up card individually to the winner
            for (int i = 0; i < players.length; i++) {
                if (faceUpCards[i] != null) {
                    players[maxIndex].receiveCard(faceUpCards[i]);
                }
            }
            System.out.println(players[maxIndex].getName() + " wins the war!");
        }

        // Check if there's a winner when all players have given their cards
        Player warWinner = determineWarWinner(players, faceUpCards);
        if (warWinner != null) {
            System.out.println(warWinner.getName() + " wins the war when all players have given their cards!");
        }
    }

    /**
     * Determines the winner of the war when all players have given their cards.
     *
     * @param players The array of players.
     * @param faceUpCards The face-up cards of all players.
     * @return The player who wins the war, or null if the war continues.
     */
        private static Player determineWarWinner(Player[] players, Card[] faceUpCards) {
        int maxIdx = 0;
        for (int i = 1; i < players.length; i++) {
            if (faceUpCards[i] != null && (faceUpCards[maxIdx] == null || faceUpCards[i].getValue() > faceUpCards[maxIdx].getValue())) {
                maxIdx = i;
            }
        }
        int tieCount = 0;
        for (int i = 0; i < players.length; i++) {
            if (faceUpCards[i] != null && faceUpCards[i].getValue() == faceUpCards[maxIdx].getValue()) {
                tieCount++;
            }
        }
        if (tieCount > 1) {
            return null; // War continues
        } else {
            return players[maxIdx]; // War winner
        }
    }
}
