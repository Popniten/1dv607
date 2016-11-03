package model.rules;

import model.Card;
import model.Player;

public class Soft17Strategy implements IHitStrategy {
    private final int g_hitLimit = 17;

    @Override
    public boolean DoHit(Player a_dealer) {
        boolean aceExist = false;
        for (Card c : a_dealer.GetHand()) {
            if (c.GetValue() == Card.Value.Ace) {
                aceExist = true;
            }
        }

        if (aceExist && a_dealer.CalcScore() <= g_hitLimit) {
            return true;
        } else {
            return a_dealer.CalcScore() < g_hitLimit;
        }
    }
}
