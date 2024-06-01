package com.leetcode.test2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
//        for (int i = 0; i <= nums.length; i++) {
//            dfs(nums, 0, i);
//        }
        dfs(nums, 0);
        return result;
    }

//    public void dfs(int[] nums, int startIndex, int k) {
//        if (path.size() == k) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = startIndex; i < nums.length && i <= nums.length - (k - path.size()) + 1; i++) {
//            path.add(nums[i]);
//            dfs(nums, i + 1, k);
//            path.remove(path.size() - 1);
//        }
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.subsets(new int[]{1, 2, 4}));
//    }

    public void dfs(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }
}
