package test4;

public class Solution {

    public static void main(String[] args) {
        System.out.println(func(20));
    }

    public static int func(int n) {
        if (n == 1) {
            return 1;
        } else {
            return func(n / 2) + n;
        }
    }

}
