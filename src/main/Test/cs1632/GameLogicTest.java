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


}