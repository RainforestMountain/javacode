package test2;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution {
    public int largestSumAfterKNegations1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
            sum = sum + nums[i];
        }
        for (int i = 0; i < k; i++) {
            int min = heap.poll();
            sum = sum - 2 * min;
            min = -min;
            heap.offer(min);
        }

//        for (Integer v : heap) {
//            sum += v;
//        }
        return sum;
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k > 0) {
            if (k % 2 == 1) {
                nums[nums.length - 1] *= -1;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums = {2, -3, -1, 5, -4};
        Solution solution = new Solution();
        System.out.println(solution.largestSumAfterKNegations(nums, 2));
    }
}
