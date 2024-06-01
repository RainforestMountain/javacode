package test5;

import java.util.HashMap;

public class Solution {
    public int subarraySum2(int[] nums, int k) {
        //滑动窗口,只能解决都是非负数的情况
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        for (; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= k && left <= right) {
                if (sum == k) {
                    count++;
                }
                sum -= nums[left];
                left++;
            }
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (dp[j + 1] - dp[i + 1 - 1] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);//处理右边界在 0 下标的情况
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            count += map.getOrDefault(sum - k, 0);//查询j之前的0 ~ i - 1 的前缀和是否有sum - k,有那么
            //i ~ j就是区间和为k的
            map.put(sum, map.getOrDefault(sum, 0) + 1);//map存储前缀和
        }
        return count;
    }
}
