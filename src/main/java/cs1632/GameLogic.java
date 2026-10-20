package cs1632;

import java.util.LinkedList;

public class GameLogic {
    final private Player p1;
    final private Player p2;
    LinkedList<PlayingCard> storedCards;



    public GameLogic(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.storedCards = new LinkedList<>();
    }

    /**
     * This does a turn for the war game
     * @return returns 1 if player 1 own, 2 if player 2 own, and 3 if a tie occurred, else 0 for no one has one yet.
     */
    public int turn() {

        PlayingCard c1;
        PlayingCard c2;

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
            storedCards.clear();
        } else if (c1.playingCardValue() == c2.playingCardValue()){
            System.out.println("Player 1 and 2's cards are of equal value.\n" +
                    "A war has occurred.");
            boolean war = true;
            while(war) {
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
                if (c1.playingCardValue() > c2.playingCardValue()) {
                    System.out.println("Player 1 has won this round.");
                    for (PlayingCard c : storedCards) {
                        p1.addToHand(c);
                        System.out.println(c.cardName() + " has been added to the player 1's hand.");
                    }
                    storedCards.clear();
                    war = false;
                } else {
                    System.out.println("Player 2 has won this round.");
                    for (PlayingCard c : storedCards) {
                        p2.addToHand(c);
                        System.out.println(c.cardName() + " has been added to the player 2's hand.");
                    }
                    storedCards.clear();
                    war = false;
                }
            }

        } else {
            System.out.println("Player 2 has won this round.");
            for (PlayingCard c : storedCards) {
                p2.addToHand(c);
                System.out.println(c.cardName() + " has been added to the player 2's hand.");
            }
            storedCards.clear();
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
