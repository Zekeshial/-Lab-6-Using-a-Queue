package cs1632;

import java.util.LinkedList;

public class Player {
    LinkedList<PlayingCard> hand;

    public Player() {
        this.hand = new LinkedList<PlayingCard>();
    }

    public LinkedList<PlayingCard> getHand() {
        return hand;
    }

    public void setHand(LinkedList<PlayingCard> hand) {
        this.hand = hand;
    }

    public void addToHand(PlayingCard c) {
        hand.add(c);
    }

    public PlayingCard pop() {
        return hand.pop();
    }

}
