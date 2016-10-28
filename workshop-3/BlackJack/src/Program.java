import model.Game;
import view.*;
import controller.*;

public class Program
{

    public static void main(String[] a_args)
    {

        int input;
        Game g = new Game();
        IView v = new SwedishView(); //new SwedishView();
        PlayGame ctrl = new PlayGame();

        do {
            v.DisplayWelcomeMessage();
            v.DisplayDealerHand(g.GetDealerHand(), g.GetDealerScore());
            v.DisplayPlayerHand(g.GetPlayerHand(), g.GetPlayerScore());

            if (g.IsGameOver())
            {
                v.DisplayGameOver(g.IsDealerWinner());
            }

            input = v.GetInput();
        }
        while (ctrl.Play(g, input));
    }
}
