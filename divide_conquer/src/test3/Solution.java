package test3;

public class Solution {
    public int getLargeArray(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    public int divide(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + ((right - left) >> 1);

        int s1 = divide(nums, left, mid);
        int s2 = divide(nums, mid + 1, right);
        //越过中线的

        int l_max = Integer.MIN_VALUE;
        int r_max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            l_max = Math.max(l_max, sum);
        }
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            r_max = Math.max(r_max, sum);
        }
        int s3 = l_max + r_max;
        return Math.max(s1, Math.max(s2, s3));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getLargeArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
