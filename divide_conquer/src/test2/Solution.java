package test2;

public class Solution {
    public long LargeInteger(long x, long y) {
        //分解
        String str1 = x + "";
        String str2 = y + "";
        if (str1.length() < 3 && str2.length() < 3) {
            return x * y;
        }
        long a = Long.parseLong(str1.substring(0, str1.length() / 2));
        long b = Long.parseLong(str1.substring(str1.length() / 2));
        long c = Long.parseLong(str2.substring(0, str2.length() / 2));
        long d = Long.parseLong(str2.substring(str2.length() / 2));
        long first = LargeInteger(a, c);
        long second = LargeInteger(a - b, d - c);
        long three = LargeInteger(b, d);
        return (long) Math.pow(2, str1.length()) * first
                + (long) Math.pow(2, str1.length() / 2) * (second + first + three) + three;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.LargeInteger(8000, 6000));
    }
}
