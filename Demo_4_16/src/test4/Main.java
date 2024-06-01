package test4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[] weight = new int[M];
        int[] value = new int[M];
        for (int i = 0; i < weight.length; i++) {
            weight[i] = scanner.nextInt();
        }
        for (int i = 0; i < value.length; i++) {
            value[i] = scanner.nextInt();
        }
        System.out.println(getBagMaxValue(weight, value, N));
    }

    public static int getBagMaxValue(int[] weight, int[] value, int N) {
        int[][] dp = new int[weight.length][N + 1];//dp[i][j]为物品0到i任取放进容量为j的背包的最大价值
        //初始化最上面那一行和最左边那一列
        for (int i = 0; i < dp.length; i++) {
            //背包容量为0,价值为0
            dp[i][0] = 0;
        }
        for (int j = 1; j < dp[0].length; j++) {
            //初始化最上面的一行,放得下才有最大价值
            if (j >= weight[0]) {
                dp[0][j] = value[0];
            }
        }
        //先遍历物品,再遍历背包
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j >= weight[i]) {
                    //放得下物品i, 那么有两种状态,放物品i和不放物品i,这两种状态取最大价值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];//放不下物品i ,那么只有不放物品i这种状态,放物品i这一种状态没有意义
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[weight.length - 1][N];
    }
}
