package com.pokergame.evaluator;

import com.pokergame.card.Card;

import java.util.List;

public interface HandEvaluator {
    int evaluate(List<Card> hand); // 플레이어 손패 점수 계산
}
