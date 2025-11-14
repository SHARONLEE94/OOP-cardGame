package com.pokergame.deck;

import com.pokergame.card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractDeck implements Deck{
    protected List<Card> cards = new ArrayList<>();

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public Card draw() {
        return cards.isEmpty() ? null : cards.remove(0);
    }

    @Override
    public void reset() {
        cards.clear();
        initialize();
        shuffle();
    }

    protected abstract void initialize(); // 구체적 덱 구성은 하위 클래스가 정의
}
