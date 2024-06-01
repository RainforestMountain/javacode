package test2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int j = 2; j < dp.length; j++) {
            for (int i = 1; i < j; i++) {
                dp[j] = Math.max(i * (j - i), Math.max(i * dp[j - i], dp[j]));
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerBreak(10));
    }
}
