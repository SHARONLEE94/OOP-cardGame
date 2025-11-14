package com.pokergame.dealer;

import com.pokergame.deck.Deck;
import com.pokergame.player.Player;

import java.util.List;

public interface Dealer {
    void dealCards(List<Player> players, Deck deck);
    Player getWinner(List<Player> players);
}
