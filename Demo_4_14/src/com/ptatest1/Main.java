package com.ptatest1;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static StringBuilder s = new StringBuilder();
    static HashSet<String> result = new HashSet<>();

    public static HashSet<String> deleteChar(String src) {
        boolean[] used = new boolean[src.length()];
        for (int i = 0; i <= 3; i++) {
            dfs(new StringBuilder(src), 0, i, used);
        }
        return result;
    }

    public static void dfs(StringBuilder src, int startIndex, int k, boolean[] used) {
        if (s.length() == k) {
            result.add(src.toString());
            return;
        }
        for (int i = startIndex; i < src.length(); i++) {
            if (i > 0 && src.charAt(i) == src.charAt(i - 1) && used[i - 1] == false) {
                continue;
            }
            char temp = src.charAt(i);
            s.append(temp);
            src.deleteCharAt(i);
            used[i] = true;
//            dfs(src.deleteCharAt(i), i, k);
            dfs(src, i, k, used);
            src.insert(i, temp);
            s.deleteCharAt(s.length() - 1);
            used[i] = false;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.print(deleteChar(str).size());

    }
}
