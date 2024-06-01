import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int pb = 0;
        int pc = 0;
        int best = Integer.MIN_VALUE / 2;
        for (int i = 0; i < nums.length - 2; i++) {
            pb = i + 1;
            pc = nums.length - 1;
            int sum = nums[i] + nums[pb] + nums[pc];
            while (pb < pc) {
                if (sum > target) {
                    pc--;
                } else if (sum == target) {
                    return target;
                } else {
                    pb++;
                }
            }
            if (Math.abs(sum - target) < Math.abs(best - target)) {
                best = sum;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 2};
        int target = 0;
        System.out.println(solution.threeSumClosest(nums, target));
    }
}
