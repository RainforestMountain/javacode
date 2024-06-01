package test5;

public class Solution {
    public int search(int[] nums, int target) {
        int x = nums[nums.length - 1];
        int left = 0;
        int right = nums.length - 1;
        //查找最小值的下标,进行分割
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int split = left;
        left = binary(nums, 0, split - 1, target);
        right = binary(nums, split, nums.length - 1, target);
        return Math.max(left, right);
    }

    public int binary(int[] nums, int start, int end, int target) {
        if (end < start) {
            return -1;
        }
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));

    }
}
