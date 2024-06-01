package com.test1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] radius = new int[N];
        for (int i = 0; i < radius.length; i++) {
            radius[i] = scanner.nextInt();
        }
        List<List<Integer>> list = new LinkedList<>();
        list = pagoda(radius);
        int len = list.get(0).size();
        for (List<Integer> value : list) {
            if (value.size() > len) {
                len = value.size();
            }
        }
        System.out.print(list.size() + " " + len);

    }

    public static List<List<Integer>> pagoda(int[] radius) {
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        List<List<Integer>> list = new LinkedList<>();
        int index = 0;
        for (; index < radius.length; index++) {
            int rc = radius[index];
            if (stackA.isEmpty() || rc < stackA.peek()) {
                stackA.push(rc);
            } else if (stackB.isEmpty() || rc > stackB.peek()) {
                stackB.push(rc);
            } else {
                List<Integer> paList = new LinkedList<>();
                int sizeA = stackA.size();
                int sizeB = stackB.size();
                for (int i = 0; i < sizeA; i++) {
                    int value = stackA.pop();
                    paList.add(0, value);
                }
                list.add(paList);
                for (int i = 0; i < sizeB; i++) {
                    int value = stackB.peek();
                    if (rc < value) {
                        stackA.push(stackB.pop());
                    }
                }
                stackA.push(rc);
            }
        }
        takeDown(stackA, list);
        takeDown(stackB, list);
        return list;
    }

    private static void takeDown(Stack<Integer> stackA, List<List<Integer>> list) {
        if (!stackA.isEmpty()) {
            List<Integer> paList = new LinkedList<>();
            int sizeA = stackA.size();
            for (int i = 0; i < sizeA; i++) {
                int value = stackA.pop();
                paList.add(0, value);
            }
            list.add(paList);
        }
    }
}
