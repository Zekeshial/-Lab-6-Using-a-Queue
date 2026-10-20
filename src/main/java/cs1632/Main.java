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
        System.out.println("player two's Hand");
        for (PlayingCard d : p2.getHand()) {
            System.out.println(d.cardName());
        }

        GameLogic game = new GameLogic(p1, p2);

        int gameResult = 0;
        int roundCounter = 0;

        while (gameResult <= 0 && roundCounter < 75000) {
            roundCounter++;
            System.out.println("Round " + roundCounter + " Begins");
            gameResult = game.turn();
            System.out.println("Round " + roundCounter + " has ended.");
        }




    }
}