package com.pokergame.deck;

import com.pokergame.card.PlayingCard;

public class StandardDeck extends AbstractDeck{
    private static final String[] SUITS = {"♠", "♥", "♦", "♣"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};


    @Override
    protected void initialize() {
        for(String suit : SUITS) {
            for(String rank : RANKS) {
                cards.add(new PlayingCard(suit, rank));
            }
        }
    }
}
