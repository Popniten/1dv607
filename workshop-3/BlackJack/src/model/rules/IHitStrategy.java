package model.rules;

import model.Player;

public interface IHitStrategy {
    boolean DoHit(Player a_dealer);
}