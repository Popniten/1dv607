package model.rules;

import model.Deck;
import model.Dealer;
import model.Player;

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    a_dealer.DrawCardToHand(a_player, true);
    a_dealer.DrawCardToHand(a_dealer, true);
    a_dealer.DrawCardToHand(a_player, true);
  
    return true;
  }
}