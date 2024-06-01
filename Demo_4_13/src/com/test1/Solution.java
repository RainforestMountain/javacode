package com.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return ans;
    }

    public void backTracking(int[] candidates, int target, int index, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates,target,i,sum);
            sum -= temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        dfs(candidates, target, 0, 0, used);
        return ans;
    }

    public void dfs(int[] candidates, int target, int index, int sum, boolean[] used) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
            //树层去重
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            temp.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            dfs(candidates, target, i + 1, sum, used);
            sum -= temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(solution.combinationSum2(candidates, 8));
    }
}
