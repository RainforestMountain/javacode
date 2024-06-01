package test2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] g = new int[][]{
                {0, 0, 0, 0}, {2, 4, 7, 11}, {5, 10, 16, 20}, {8, 12, 17, 22}
        };
        int[] xValue = {0, 1, 2, 3};
        int[][] dp = new int[4][11];//dp[i][j]选了前i个未知数,平方和为j的结果最大值

        for (int j = 0; j < dp[0].length; j++) {
            int val = (int) Math.sqrt(j);
            if (val * val == j) {
                dp[1][j] = g[1][val];
            }
        }
        //递归公式
        //dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - k] + g[i][Math.sqrt(k)] ,0 <= k <= j,且k为平方数
        //dp[i][j]由选择i - 1个未知数的最大值加上第i个未知数的函数gi(i) 的总和推出,满足约束条件
        // 这i个数平方和为j ,前 i - 1个平方和为j - k,第i个平方和为 k,然后取最大值
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k <= j; k++) {
                    int val = (int) Math.sqrt(k);
                    if (val * val == k) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k] + g[i][val]);
                    }
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        int max = 0;
        //最大值不一定是平方和最大的情况,但一定是选择了3个未知数
        for (int j = 0; j < dp[3].length; j++) {
            max = Math.max(max, dp[3][j]);
        }
        System.out.println(max);
    }
}
