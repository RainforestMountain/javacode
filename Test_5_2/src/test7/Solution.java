package test7;

public class Solution {
    public int findMin(int[] nums) {
        int x = nums[nums.length - 1];
        //根据x进行二分
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > x) {
                left = mid + 1;
            } else if (nums[mid] < x) {
                right = mid;
            } else {
                if (nums[left] < nums[right]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{3, 1, 3}));
    }
}
