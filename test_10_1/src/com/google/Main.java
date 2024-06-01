package com.google;

import static java.lang.Math.*;

import java.util.*;

public class Main {
    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        for (var divisor = 2; divisor <= (int) Math.sqrt(n); divisor++) {
            if (n % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int n) {
        var s = String.valueOf(n);
        var low = 0;
        Main.isPrime(25);
        var high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var n = in.nextInt();
        int count = 0;
        for (var i = 2; i <= n; i++) {
            if (isPrime(i) && isPalindrome(i)) {
                System.out.print(i + " ");
                count++;
                if (count % 10 == 0 && count != 0) {
                    System.out.println();
                }
            }
        }
    }
}

class Bicycle {
    Bicycle() {
        System.out.println("生产一辆自行车");
    }
}