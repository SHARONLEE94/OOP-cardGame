package com.pokergame.evaluator;

import com.pokergame.card.Card;

import java.util.*;

public class PokerHandEvaluator implements HandEvaluator {
    private static final List<String> RANK_ORDER = List.of(
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    );

    @Override
    public int evaluate(List<Card> hand) {
        Map<String, Integer> rankCount = new HashMap<>();
        Map<String, Integer> suitCount = new HashMap<>();

        for(Card card : hand) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0)+1);
            suitCount.put(card.getSuit(), suitCount.getOrDefault(card.getSuit(), 0)+1);
        }

        boolean isFlush = suitCount.values().stream().anyMatch(c -> c == 5);
        boolean isStraight = checkStraight(hand);
        int pairs = 0; boolean three = false; boolean four = false;

        for (int count : rankCount.values()) {
            if (count == 4) four = true;
            else if (count == 3) three = true;
            else if (count == 2) pairs++;
        }

        if (isStraight && isFlush && isRoyal(hand)) return 900;
        if (isStraight && isFlush) return 800;
        if (four) return 700;
        if (three && pairs == 1) return 600;
        if (isFlush) return 500;
        if (isStraight) return 400;
        if (three) return 300;
        if (pairs == 2) return 200;
        if (pairs == 1) return 100;
        return 0;
    }

    private boolean checkStraight(List<Card> hand) {
        List<Integer> ranks = new ArrayList<>();
        for(Card card : hand) ranks.add(RANK_ORDER.indexOf(card.getRank()));
        Collections.sort(ranks);
        for (int i = 0; i < ranks.size() - 1; i++) {
            if (ranks.get(i + 1) - ranks.get(i) != 1) return false;
        }
        return true;
    }

    private boolean isRoyal(List<Card> hand) {
        Set<String> royal = Set.of("10", "J", "Q", "K", "A");
        Set<String> ranks = new HashSet<>();
        for (Card card : hand) ranks.add(card.getRank());
        return ranks.equals(royal);
    }
}
