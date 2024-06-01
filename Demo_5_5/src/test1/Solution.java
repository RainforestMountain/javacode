package test1;

public class Solution {
    public void moveZeroes(int[] nums) {
        int cur = 0;
        int pre = -1;
        while (cur < nums.length) {
            if (nums[cur] == 0) {
                cur++;
            } else {
                pre++;
                int temp = nums[cur];
                nums[cur] = nums[pre];
                nums[pre] = temp;
                cur++;
            }
        }
    }
}
