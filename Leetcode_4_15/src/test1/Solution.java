package test1;

public class Solution {
    public int jump(int[] nums) {
        int cover = 0;
        int cover_next = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            cover_next = Math.max(i + nums[i], cover_next);
            if (i == cover) {
                if (cover < nums.length - 1) {
                    count++;
                    cover = cover_next;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(solution.jump(nums));
    }
}
