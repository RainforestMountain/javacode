package org.work2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardGame {
    private static final String[] SUITS = {"梅花", "方块", "红心", "黑桃"};
    private static final String[] RANKS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private static final String[] JOKERS = {"大王", "小王"};

    public static void main(String[] args) {
        List<String> deck = createDeck();
        bridge(deck);
        douDizhu(deck);
    }

    public static List<String> createDeck() {
        List<String> deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck.add(suit + rank);
            }
        }
        Collections.addAll(deck, JOKERS);
        Collections.shuffle(deck);
        return deck;
    }

    public static void bridge(List<String> deck) {
        List<String> player1 = new ArrayList<>();
        List<String> player2 = new ArrayList<>();
        List<String> player3 = new ArrayList<>();
        List<String> player4 = new ArrayList<>();

        for (int i = 0; i < deck.size() - 2; i++) {
            String card = deck.get(i);
            if (i % 4 == 0) player1.add(card);
            else if (i % 4 == 1) player2.add(card);
            else if (i % 4 == 2) player3.add(card);
            else player4.add(card);
        }

        System.out.println("桥牌发牌：");
        System.out.println("玩家1：" + player1);
        System.out.println("玩家2：" + player2);
        System.out.println("玩家3：" + player3);
        System.out.println("玩家4：" + player4);
    }

    public static void douDizhu(List<String> deck) {
        List<String> player1 = new ArrayList<>();
        List<String> player2 = new ArrayList<>();
        List<String> player3 = new ArrayList<>();
        List<String> bottom = new ArrayList<>();

        for (int i = 0; i < deck.size(); i++) {
            String card = deck.get(i);
            if (i < 51) {
                if (i % 3 == 0) player1.add(card);
                else if (i % 3 == 1) player2.add(card);
                else player3.add(card);
            } else {
                bottom.add(card);
            }
        }

        System.out.println("斗地主发牌：");
        System.out.println("玩家1：" + player1);
        System.out.println("玩家2：" + player2);
        System.out.println("玩家3：" + player3);
        System.out.println("底牌：" + bottom);
    }
}
