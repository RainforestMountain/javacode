package test4;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productFront = new int[nums.length];
        int[] productRear = new int[nums.length];
        //不包含nums[i]的前缀积
        for (int i = 0; i < productFront.length; i++) {
            if (i == 0) {
                productFront[i] = 1;
            } else {
                productFront[i] = productFront[i - 1] * nums[i - 1];
            }
        }
        for (int i = productRear.length - 1; i >= 0; i--) {
            if (i == productRear.length - 1) {
                productRear[i] = 1;
            } else {
                productRear[i] = productRear[i + 1] * nums[i + 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = productFront[i] * productRear[i];
        }
        return nums;
    }

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                answer[0] = 1;
            } else {
                answer[i] = answer[i - 1] * nums[i - 1];
            }
        }
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                answer[i] = answer[i] * R;
            } else {
                R = R * nums[i + 1];
                answer[i] = answer[i] * R;
            }
        }
        return answer;
    }
}
