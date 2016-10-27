package model.rules;

import model.Dealer;
import model.Player;

public interface IWinStrategy {
    boolean IsDealerWinner(Dealer d, Player p, int maxScore);
}
