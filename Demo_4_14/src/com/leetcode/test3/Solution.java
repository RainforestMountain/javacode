package com.leetcode.test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, used);
        return result;
    }

    public void dfs(int[] nums, int startIndex, boolean[] used) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, i + 1, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
