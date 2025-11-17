package com.pokergame.game;

import com.pokergame.dealer.Dealer;
import com.pokergame.deck.Deck;
import com.pokergame.player.Player;

import java.util.List;
import java.util.Random;

public class PokerGame extends  AbstractGame  {

    public PokerGame(Dealer dealer, Deck deck, List<Player> players) {
        super(dealer, deck, players);
    }

    @Override
    public void start() {
        super.start();

        System.out.println("===== 포커 게임 시작 =====");

        for (int round = 1; round <= 100; round++) {
            System.out.println("===== Round " + round + " =====");
            deck.reset();
            dealer.dealCards(players, deck);

            Player winner = dealer.getWinner(players);
            if (winner != null) {
                winner.addWin();
                winner.addMoney(100);
                players.stream()
                        .filter(p -> !p.equals(winner))
                        .forEach(Player::addLose);

                // 라운드별 승자
                System.out.println("Round " + round + " 승자: " + winner.getNickname());
            }

            players.forEach(Player::clearHand);
        }

        System.out.println("===== 최종 결과 =====");
        players.stream()
                .sorted((p1, p2) -> {
                    int compare = Integer.compare(p2.getWinCount(), p1.getWinCount());
                    return (compare != 0) ? compare : new Random().nextInt(3) - 1;
                })
                .forEach(p ->
                        System.out.println(p.getNickname() + " / 승: " + p.getWinCount() +
                                " / 패: " + p.getLoseCount() + " / 잔액: " + p.getMoney())
                );

        end();
    }

}
