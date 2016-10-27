package model.rules;

import model.Deck;
import model.Dealer;
import model.Player;

public interface INewGameStrategy {
    boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player);
}