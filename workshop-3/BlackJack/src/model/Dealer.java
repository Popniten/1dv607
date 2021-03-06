package model;

import model.rules.*;

public class Dealer extends Player {

    private Deck m_deck;
    private INewGameStrategy m_newGameRule;
    private IHitStrategy m_hitRule;
    private IWinStrategy m_winRule;

    public Dealer(RulesFactory a_rulesFactory) {
        m_newGameRule = a_rulesFactory.GetNewGameRule();
        m_hitRule = a_rulesFactory.GetHitRule();
        m_winRule = a_rulesFactory.GetNewWinRule();
    }

    public void DrawCardToHand(Player a_player, boolean show) {
        Card c = m_deck.GetCard();
        c.Show(show);
        a_player.DealCard(c);
    }

    public boolean Stand() {
        if (m_deck != null) {
            this.ShowHand();

            while (m_hitRule.DoHit(this)) {
                DrawCardToHand(this, true);
            }

            return true;
        }
        return false;
    }

    public boolean NewGame(Player a_player) {
        if (m_deck == null || IsGameOver()) {
            m_deck = new Deck();
            ClearHand();
            a_player.ClearHand();
            return m_newGameRule.NewGame(m_deck, this, a_player);
        }
        return false;
    }

    public boolean Hit(Player a_player) {
        if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
            DrawCardToHand(a_player, true);

            return true;
        }
        return false;
    }

    public boolean IsDealerWinner(Player a_player) {
        return m_winRule.IsDealerWinner(this, a_player, g_maxScore);
    }

    public boolean IsGameOver() {
        if (m_deck != null && m_hitRule.DoHit(this) != true) {
            return true;
        }
        return false;
    }

}
