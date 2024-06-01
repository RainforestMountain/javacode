package com.test;

public class Test {
    public static void main(String[] args) {
        StringBuilder src = new StringBuilder("nihao");
        dfs(src, src.length(), 0);
    }

    public static void dfs(StringBuilder src, int length, int i) {
        if (length <= 1) {
            return;
        }
        length = src.length();
        System.out.println(src.toString());
        dfs(src.deleteCharAt(i), length, i);
        System.out.println();
    }
}
