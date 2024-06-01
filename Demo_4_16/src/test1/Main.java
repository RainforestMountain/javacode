package test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        char b = scanner.next().charAt(0);
        int cost = 0;
        if (a <= 1) {
            cost = 20;
            if (b == 'y') {
                cost = cost + 5;
            }
        } else {
            double exact = Math.ceil(a - 1);
            cost = 20 + (int) (exact * 1);
            if (b == 'y') {
                cost = cost + 5;
            }
        }
        System.out.println(cost);
    }
}
