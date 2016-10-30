package model;

import java.util.ArrayList;

public class Game {

    private Dealer m_dealer;
    private Player m_player;
    private ArrayList<ICardDealtObserver> m_subscribers;

    public Game()
    {
        m_subscribers = new ArrayList<>();
        m_dealer = new Dealer(new model.rules.RulesFactory());
        m_player = new Player();
        m_dealer.AddSubscribeList(m_subscribers);
        m_player.AddSubscribeList(m_subscribers);
    }

    public void AddSubscriber(ICardDealtObserver a_sub) {
        m_subscribers.add(a_sub);
    }

    public boolean IsGameOver()
    {
        return m_dealer.IsGameOver();
    }

    public boolean IsDealerWinner()
    {
        return m_dealer.IsDealerWinner(m_player);
    }

    public boolean NewGame()
    {
        return m_dealer.NewGame(m_player);
    }

    public boolean Hit()
    {
        return m_dealer.Hit(m_player);
    }

    public boolean Stand()
    {
        return m_dealer.Stand();
    }

    public Iterable<Card> GetDealerHand()
    {
        return m_dealer.GetHand();
    }

    public Iterable<Card> GetPlayerHand()
    {
        return m_player.GetHand();
    }

    public int GetDealerScore()
    {
        return m_dealer.CalcScore();
    }

    public int GetPlayerScore()
    {
        return m_player.CalcScore();
    }

}
