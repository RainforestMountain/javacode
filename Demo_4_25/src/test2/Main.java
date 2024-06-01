package test2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int n = 5;
//        int[] weight = {1, 2, 3, 4, 5};
//        int[] values = {5, 10, 8, 7, 9};


        int[] dp = new int[7];

//        for (int i = 0; i < weight.length; i++) {
//            for (int j = weight[i]; j < dp.length; j++) {
//                dp[j] = Math.max(dp[j], dp[j - weight[i]] + values[i]);
//            }
//        }

//        for (int j = dp.length - 1; j >= 0; j--) {
//            for (int i = 0; i < weight.length; i++) {
//                if (j >= weight[i]) {
//                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + values[i]);
//                } else {
//                    dp[j] = dp[j];
//                }
//            }
//        }
        int[] nums = {1, 2, 3};
        dp[0] = 1;
        //求种类数
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = nums[i]; j < dp.length; j++) {
//                dp[j] = dp[j] + dp[j - nums[i]];
//            }
//        }

        for (int j = 0; j < dp.length; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
        }


        System.out.println(Arrays.toString(dp));
    }
}
