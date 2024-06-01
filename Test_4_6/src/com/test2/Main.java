package com.test2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Stack<Integer> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i < N; i++) {
            int value = scanner.nextInt();
            s1.push(value);
        }
        for (int i = 0; i < (N - 1); i++) {
            char ch = scanner.next().charAt(0);
            s2.push(ch);
        }
        try {
            while (!s2.isEmpty()) {

                int n1 = s1.pop();
                int n2 = s1.pop();
                char op = s2.pop();
                int ans = 0;
                switch (op) {
                    case '+' -> ans = n2 + n1;
                    case '-' -> ans = n2 - n1;
                    case '*' -> ans = n2 * n1;
                    case '/' -> {
                        if (n1 == 0) {
                            throw new RuntimeException("ERROR:" + n2 + '/' + n1);
                        } else {
                            ans = n2 / n1;
                        }
                    }
                }
                s1.push(ans);
            }

            int ret = s1.pop();
            System.out.println(ret);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }


    }
}
