package view;

public class SimpleView implements IView
{
    private char charForNewGame = 'p';
    private char charForHit = 'h';
    private char charForStand = 's';
    private char charForQuit = 'q';

    public void DisplayWelcomeMessage()
    {
        for(int i = 0; i < 50; i++) {System.out.print("\n");}
        System.out.println("Hello Black Jack World");
        System.out.println("Type '"
                + charForNewGame + "' to Play, '"
                + charForHit + "' to Hit, '"
                + charForStand + "' to Stand or '"
                + charForQuit + "' to Quit\n");
    }

    public int GetInput()
    {
        try {
            int c = System.in.read();
            while (c == '\r' || c =='\n') {
                c = System.in.read();
            }
            return c;
        } catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
        }
    }

    public void DisplayCard(model.Card a_card)
    {
        System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score)
    {
        DisplayHand("Player", a_hand, a_score);
    }

    public void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score)
    {
        DisplayHand("Dealer", a_hand, a_score);
    }

    private void DisplayHand(String a_name, Iterable<model.Card> a_hand, int a_score)
    {
        System.out.println(a_name + " Has: ");
        for(model.Card c : a_hand)
        {
            DisplayCard(c);
        }
        System.out.println("Score: " + a_score);
        System.out.println("");
    }

    public void DisplayGameOver(boolean a_dealerIsWinner)
    {
        System.out.println("GameOver: ");
        if (a_dealerIsWinner)
        {
            System.out.println("Dealer Won!");
        }
        else
        {
            System.out.println("You Won!");
        }

    }

    public char GetInputFor(InputChoice choice) {
        char c = 'x';
        if (choice == InputChoice.NewGame) {c = charForNewGame;}
        if (choice == InputChoice.Hit) {c = charForHit;}
        if (choice == InputChoice.Stand) {c = charForStand;}
        if (choice == InputChoice.Quit) {c = charForQuit;}

        return c;
    }
}
