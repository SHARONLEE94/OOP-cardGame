package com.pokergame.deck;

import com.pokergame.card.Card;

public interface Deck {
    void shuffle(); // 카드 섞기
    Card draw(); // 한 장 뽑기
    void reset(); // 초기화
}
