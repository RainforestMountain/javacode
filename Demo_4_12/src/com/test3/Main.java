package com.test3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class People {
    int id;
    int money;
    int count_red;
}

public class Main {
    public static void initPeopleArray(People[] peoples) {
        for (int i = 0; i < peoples.length; i++) {
            peoples[i] = new People();
            peoples[i].id = i + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        People[] peopels = new People[N];
        initPeopleArray(peopels);
        for (int i = 0; i < N; i++) {
            int K = scanner.nextInt();
            int sumMoney = 0;
            for (int j = 0; j < K; j++) {
                int people_id = scanner.nextInt() - 1;
                int money = scanner.nextInt();
                sumMoney += money;
                peopels[people_id].money += money;
                peopels[people_id].count_red++;
            }
            peopels[i].money -= sumMoney;
        }

        Arrays.sort(peopels, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o1.money < o2.money) {
                    return 1;
                } else if (o1.money > o2.money) {
                    return -1;
                } else {
                    if (o1.count_red < o2.count_red) {
                        return 1;
                    } else if (o1.count_red > o2.count_red) {
                        return -1;
                    } else {
                        return o1.id - o2.id;
                    }
                }
            }
        });
        for (int i = 0; i < peopels.length; i++) {
            System.out.print(peopels[i].id + " ");
            System.out.printf("%.2f\n", peopels[i].money * 1.0 / 100);
        }
    }
}