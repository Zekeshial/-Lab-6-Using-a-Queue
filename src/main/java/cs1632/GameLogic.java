package cs1632;

import java.util.LinkedList;

public class GameLogic {
    private Player p1;
    private Player p2;



    public GameLogic(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public int turn() {
        LinkedList<PlayingCard> storedCards = new LinkedList<>();

        PlayingCard c1 = null;
        PlayingCard c2 = null;

        if (!p1.getHand().isEmpty()) {
            c1 = p1.pop();
            System.out.println("Player 1 plays: " + c1.cardName());
        } else {
            System.out.println("Player 1 is out of cards.");
            System.out.println("Player 2 has won.");
            return 2;
        }

        if (!p2.getHand().isEmpty()) {
            c2 = p2.pop();
            System.out.println("Player 2 plays: " + c2.cardName());
        } else {
            System.out.println("Player 2 is out of cards.");
            System.out.println("Player 1 has won.");
            return 1;
        }

        storedCards.add(c1);
        storedCards.add(c2);

        if (c1.playingCardValue() > c2.playingCardValue()) {
            System.out.println("Player 1 has won this round.");
            for (PlayingCard c : storedCards) {
                p1.addToHand(c);
                System.out.println(c.cardName() + " has been added to the player 1's hand.");
            }
        } else if (c1.playingCardValue() == c2.playingCardValue()){
            System.out.println("Player 1 and 2's cards are of equal value.\n" +
                    "A war has occurred.");
            for (int i = 0; i < 2; i++) {
                if (p1.getHand().isEmpty() && p2.getHand().isEmpty()) {
                    System.out.println("Player 1 and 2's hands are both empty a draw has occurred");
                    return 3;
                }

                if (!p1.getHand().isEmpty()) {
                    c1 = p1.pop();
                    System.out.println("Player 1 plays: " + c1.cardName());
                    storedCards.add(c1);
                } else {
                    System.out.println("Player 1 is out of cards.");
                    System.out.println("Player 2 has won.");
                    return 2;
                }

                if (!p2.getHand().isEmpty()) {
                    c2 = p2.pop();
                    System.out.println("Player 2 plays: " + c2.cardName());
                    storedCards.add(c2);
                } else {
                    System.out.println("Player 2 is out of cards.");
                    System.out.println("Player 1 has won.");
                    return 1;
                }
            }
            turn();
        } else {
            System.out.println("Player 2 has won this round.");
            for (PlayingCard c : storedCards) {
                p2.addToHand(c);
                System.out.println(c.cardName() + " has been added to the player 2's hand.");
            }
        }

        if(p1.getHand().isEmpty()) {
            System.out.println("Player 1 is out of cards.");
            System.out.println("Player 2 has won.");
            return 2;
        } else if (p2.getHand().isEmpty()) {
            System.out.println("Player 2 is out of cards.");
            System.out.println("Player 1 has won.");
            return 1;
        } else {
            return 0;
        }
    }


}
