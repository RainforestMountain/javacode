package com.test1;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            map.put((i + 1), 0);
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            for (int j = a; j <= b; j++) {
                int value = map.get(j);
                map.put(j, c + value);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + map.get(i + 1) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n + 2];
        int[] B = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
            B[i] = arr[i] - arr[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            B[l] = B[l] + c;
            B[r + 1] = B[r + 1] - c;
        }
        for (int i = 1; i <= n; i++) {
            arr[i] = B[i] + arr[i - 1];
            System.out.print(arr[i] + " ");
        }
    }
}
