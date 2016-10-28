package controller;

import model.Game;

public class PlayGame {

  public boolean Play(Game a_game, int input) {

    if (input == 'p')
    {
        a_game.NewGame();
    }
    else if (input == 'h')
    {
        a_game.Hit();
    }
    else if (input == 's')
    {
        a_game.Stand();
    }

    return input != 'q';
  }
}