package model.rules;

import model.Dealer;
import model.Player;

public class DealerWinsIfEqual implements IWinStrategy {

    @Override
    public boolean IsDealerWinner(Dealer a_dealer, Player a_player, int g_maxScore) {
        if (a_player.CalcScore() > g_maxScore) {
            return true;
        } else if (a_dealer.CalcScore() > g_maxScore) {
            return false;
        } else if (a_dealer.CalcScore() == a_player.CalcScore()) {
            return true;
        } else {
            return a_dealer.CalcScore() > a_player.CalcScore();
        }
    }
}
