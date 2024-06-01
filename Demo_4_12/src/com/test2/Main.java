package com.test2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            List<Integer> list = new ArrayList<>();
            while (scanner.hasNext()) {
                list.add(scanner.nextInt());
            }
            map.put(i, list);
        }
        func(map, N);
    }

    public static void func(HashMap<Integer, List<Integer>> map, int N) {
        int count_home = 0;
        List<Integer> list = new LinkedList<>();
        list.addAll(map.keySet());
        while (!list.isEmpty()) {

        }

    }
}
