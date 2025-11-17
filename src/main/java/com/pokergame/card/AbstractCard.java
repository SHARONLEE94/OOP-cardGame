package com.pokergame.card;

public abstract class AbstractCard implements Card{
    protected String suit;
    protected String rank;

    public AbstractCard(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String getSuit() {
        return suit;
    }

    @Override
    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return suit + " " + rank;
    }
}
