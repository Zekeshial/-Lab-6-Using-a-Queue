package cs1632;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;
class GameLogicTest {

    @Test
    void turnTest1() {
        LinkedList<PlayingCard> cardDeck = new LinkedList<>();
        PlayingCard [] cards = new PlayingCard[PlayingCard.CardValues.length * PlayingCard.SuitValues.length];
        int cn = 0;
        for (int cv = 0; cv < PlayingCard.CardValues.length; cv++) {
            for (int sv = 0; sv < PlayingCard.SuitValues.length; sv++) {
                cards[cn] = new PlayingCard(cv,sv);
                cn++;
            }
        }

        for (int i = PlayingCard.CardValues.length * PlayingCard.SuitValues.length; i >= 1; i--) {
            cardDeck.add(cards[i-1]);
        }

        Player p1 = new Player();
        Player p2 = new Player();
        System.out.println(cardDeck.get(5).playingCardValue() + " " + cardDeck.get(5).cardName());
        System.out.println(cardDeck.get(5).cardName());
        p1.addToHand(cardDeck.get(5));
        System.out.println(cardDeck.get(6).playingCardValue() + " " + cardDeck.get(6).cardName());
        p2.addToHand(cardDeck.get(6));

        GameLogic game = new GameLogic(p1, p2);

        int actual = game.turn();
        int expected = 3;

        assertEquals(expected, actual);
    }


    @Test
    void turnTest2() {
        LinkedList<PlayingCard> cardDeck = new LinkedList<>();
        PlayingCard [] cards = new PlayingCard[PlayingCard.CardValues.length * PlayingCard.SuitValues.length];
        int cn = 0;
        for (int cv = 0; cv < PlayingCard.CardValues.length; cv++) {
            for (int sv = 0; sv < PlayingCard.SuitValues.length; sv++) {
                cards[cn] = new PlayingCard(cv,sv);
                cn++;
            }
        }

        for (int i = PlayingCard.CardValues.length * PlayingCard.SuitValues.length; i >= 1; i--) {
            cardDeck.add(cards[i-1]);
        }

        Player p1 = new Player();
        Player p2 = new Player();
        System.out.println(cardDeck.get(27).playingCardValue() + " " + cardDeck.get(27).cardName());
        System.out.println(cardDeck.get(27).cardName());
        p1.addToHand(cardDeck.get(27));
        System.out.println(cardDeck.get(6).playingCardValue() + " " + cardDeck.get(6).cardName());
        p2.addToHand(cardDeck.get(6));

        GameLogic game = new GameLogic(p1, p2);

        int actual = game.turn();
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    void turnTest3() {
        LinkedList<PlayingCard> cardDeck = new LinkedList<>();
        PlayingCard [] cards = new PlayingCard[PlayingCard.CardValues.length * PlayingCard.SuitValues.length];
        int cn = 0;
        for (int cv = 0; cv < PlayingCard.CardValues.length; cv++) {
            for (int sv = 0; sv < PlayingCard.SuitValues.length; sv++) {
                cards[cn] = new PlayingCard(cv,sv);
                cn++;
            }
        }

        for (int i = PlayingCard.CardValues.length * PlayingCard.SuitValues.length; i >= 1; i--) {
            cardDeck.add(cards[i-1]);
        }

        Player p1 = new Player();
        Player p2 = new Player();
        System.out.println(cardDeck.get(27).playingCardValue() + " " + cardDeck.get(27).cardName());
        System.out.println(cardDeck.get(27).cardName());
        p2.addToHand(cardDeck.get(27));
        System.out.println(cardDeck.get(6).playingCardValue() + " " + cardDeck.get(6).cardName());
        p1.addToHand(cardDeck.get(6));

        GameLogic game = new GameLogic(p1, p2);

        int actual = game.turn();
        int expected = 1;

        assertEquals(expected, actual);
    }

    //This test will fail if the game ends early due to the play not needing to add cards to their hand sense they won.
    //This test also test if the total number of cards in both players hands is always 52 when you run a total of 100 runs
    @Test
    void turnTest4() {
        PlayingCardDeck deck = new PlayingCardDeck();




        Player p1 = new Player();
        Player p2 = new Player();

        while (!deck.isEmpty()) {
            PlayingCard c = deck.nextCard();
            p1.addToHand(c);
            PlayingCard d = deck.nextCard();
            p2.addToHand(d);
        }



        GameLogic game = new GameLogic(p1, p2);
        int gameResult = 0;
        int roundCounter = 0;

        while (gameResult <= 0 && roundCounter < 100) {
            roundCounter++;
            System.out.println("Round " + roundCounter + " Begins");
            gameResult = game.turn();
            System.out.println("Round " + roundCounter + " has ended.");
        }
        int actual = p2.getHand().size() + p1.getHand().size();
        int expected = 52;

        assertEquals(expected, actual);
    }


}