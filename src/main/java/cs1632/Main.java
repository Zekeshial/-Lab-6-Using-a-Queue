package cs1632;

public class Main {
    public static void main(String[] args) {
        PlayingCardDeck deck = new PlayingCardDeck();
        Player p1 = new Player();
        Player p2 = new Player();

        while (!deck.isEmpty()) {
            PlayingCard c = deck.nextCard();
            p1.addToHand(c);
            PlayingCard d = deck.nextCard();
            p2.addToHand(d);
        }


        System.out.println("player one's hand");
        for (PlayingCard c : p1.getHand()) {
            System.out.println(c.cardName());
        }
        System.out.println();
        System.out.println("palyer two's Hand");
        for (PlayingCard d : p2.getHand()) {
            System.out.println(d.cardName());
        }



    }
}