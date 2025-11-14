package com.pokergame.player;

import com.pokergame.card.Card;

import java.util.List;

public interface Player {
    String getNickname();
    void receiveCard(Card card);
    void clearHand();
    List<Card> getHand();
    void addWin();
    void addLose();
    void addMoney(int amount);
    int getMoney();
    int getWinCount();
    int getLoseCount();
}
