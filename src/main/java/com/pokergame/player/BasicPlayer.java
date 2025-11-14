package com.pokergame.player;

import com.pokergame.card.Card;

import java.util.ArrayList;
import java.util.List;

public class BasicPlayer implements Player{
    private final String nickName;
    private final List<Card> hand = new ArrayList<>();
    private int money = 10000;
    private int winCount = 0;
    private int loseCount = 0;

    public BasicPlayer(String nickName) {
        if(nickName.length() > 20) throw new IllegalArgumentException("닉네임은 20자 이하만 가능합니다.");
        this.nickName = nickName;
    }

    @Override
    public String getNickname() {
        return nickName;
    }

    @Override
    public void receiveCard(Card card) {
        hand.add(card);
    }

    @Override
    public void clearHand() {
        hand.clear();
    }

    @Override
    public List<Card> getHand() {
        return hand;
    }

    @Override
    public void addWin() {
        winCount++;
    }

    @Override
    public void addLose() {
        loseCount++;
    }

    @Override
    public void addMoney(int amount) {
        money += amount;
    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public int getWinCount() {
        return winCount;
    }

    @Override
    public int getLoseCount() {
        return loseCount;
    }

    public void showHand() {
        System.out.println(nickName  + " / 승: " + winCount + " / 패: " + loseCount + " / 잔액: " + money);
    }
}
