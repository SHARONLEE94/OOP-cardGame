package com.pokergame.dealer;

import com.pokergame.deck.Deck;
import com.pokergame.evaluator.HandEvaluator;
import com.pokergame.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DealerImpl implements Dealer{
    private final HandEvaluator evaluator;

    public DealerImpl(HandEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    @Override
    public void dealCards(List<Player> players, Deck deck) {
        for(int i=0; i < 5; i++) {
            for(Player player : players) {
                player.receiveCard(deck.draw());
            }
        }
    }

    @Override
    public Player getWinner(List<Player> players) {
        Player winner = null;
        int bestScore = -1;
        List<Player> tiedPlayers = new ArrayList<>();

        for (Player player : players) {
            int score = evaluator.evaluate(player.getHand());
            if (score > bestScore) {
                bestScore = score;
                tiedPlayers.clear();
                tiedPlayers.add(player);
            } else if (score == bestScore) {
                tiedPlayers.add(player);
            }
        }

        if (!tiedPlayers.isEmpty()) {
            Random random = new Random();
            winner = tiedPlayers.get(random.nextInt(tiedPlayers.size()));
        }

        return winner;
    }
}
