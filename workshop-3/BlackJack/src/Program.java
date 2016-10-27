import model.Game;
import view.*;
import controller.*;

public class Program
{

    public static void main(String[] a_args)
    {

        Game g = new Game();
        IView v = new SimpleView(); //new SwedishView();
        PlayGame ctrl = new PlayGame();

        while (ctrl.Play(g, v));
    }
}
