package cs1632;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @org.junit.jupiter.api.Test
    void addToHand() {
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
        p1.addToHand(cards[5]);
        p1.addToHand(cards[6]);
        p1.addToHand(cards[17]);
        p1.addToHand(cards[50]);

        PlayingCard actual = p1.pop();
        PlayingCard expected = cards[5];

        assertEquals(actual, expected);


    }
}