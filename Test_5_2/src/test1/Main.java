package test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] strings = str.split("-");
        int k = 1;
        int sum = 0;
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                sum += (strings[i].charAt(j) - '0') * k;
                k++;
            }
        }
        sum = sum % 11;
        char ch = 0;
        if (sum == 10) {
            ch = 'X';
        } else {
            ch = (char)(sum + '0');
        }
        if (ch == (strings[strings.length - 1].charAt(0) - '0')) {
            System.out.println("Right");
        } else {
            System.out.println(strings[0] + "-" + strings[1] + "-" + strings[2] + "-" + sum);
        }
    }
}
