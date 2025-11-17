package com.pokergame.game;

import com.pokergame.dealer.Dealer;
import com.pokergame.deck.Deck;
import com.pokergame.player.Player;

import java.util.List;

public abstract class AbstractGame implements Game{
    protected Dealer dealer;
    protected Deck deck;
    protected List<Player> players;

    public AbstractGame (Dealer dealer, Deck deck, List<Player> players) {
        this.dealer = dealer;
        this.deck = deck;
        this.players = players;
    }

    @Override
    public void start() {
        System.out.println("게임 시작!");
    }

    @Override
    public void end() {
        System.out.println("게임 종료!");
    }
}
