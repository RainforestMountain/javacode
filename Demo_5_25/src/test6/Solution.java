package test6;

import java.util.HashMap;

public class Solution {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 2 * dp[i] - i;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int j = 0; j < dp.length; j++) {
            if (map.containsKey(dp[j])) {
                res = Math.max(res, j - map.get(dp[j]));
                //有相同的不插入,保证相同的在最左边
            } else {
                map.put(dp[j], j);
            }
        }
        return res;
    }
}
