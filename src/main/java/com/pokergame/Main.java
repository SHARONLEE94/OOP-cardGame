package com.pokergame;

import com.pokergame.dealer.Dealer;
import com.pokergame.dealer.DealerImpl;
import com.pokergame.deck.Deck;
import com.pokergame.deck.StandardDeck;
import com.pokergame.evaluator.PokerHandEvaluator;
import com.pokergame.game.Game;
import com.pokergame.game.PokerGame;
import com.pokergame.player.BasicPlayer;
import com.pokergame.player.Player;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Deck deck = new StandardDeck();
        List<Player> players = List.of(
                new BasicPlayer("예린"),
                new BasicPlayer("민준"),
                new BasicPlayer("수진"),
                new BasicPlayer("동재")
        );

        Dealer dealer = new DealerImpl(new PokerHandEvaluator());
        Game game = new PokerGame(dealer, deck, players);
        game.start();
    }
}
