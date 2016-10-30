package controller;

import model.ICardDealtObserver;
import view.IView;
import model.Game;

public class PlayGame implements ICardDealtObserver {
    private Game m_game;
    private IView m_view;

    public PlayGame(Game a_game, IView a_view) {
        m_game = a_game;
        m_view = a_view;
        m_game.AddSubscriber(this);
        m_view.DisplayWelcomeMessage();
    }

    public boolean Play() {

        if (m_game.IsGameOver())
        {
            m_view.DisplayGameOver(m_game.IsDealerWinner());
        }

        int input = m_view.GetInput();

        if (input == m_view.GetInputFor(IView.InputChoice.NewGame))
        {
            m_game.NewGame();
        }
        else if (input == m_view.GetInputFor(IView.InputChoice.Hit))
        {
            m_game.Hit();
        }
        else if (input == m_view.GetInputFor(IView.InputChoice.Stand))
        {
            m_game.Stand();
        }

        return input != m_view.GetInputFor(IView.InputChoice.Quit);
    }

    @Override
    public void CardDealt() {
        m_view.DisplayWelcomeMessage();
        m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
        m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());

        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}