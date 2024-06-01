package com.leetcode.test5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, nums.length, used);
        return result;
    }

    public void dfs(int[] nums, int k, boolean[] used) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
                continue;
            }
            if (used[i] == true) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, k, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
    }
}
