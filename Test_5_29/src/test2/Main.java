package test2;

import java.util.Stack;
import java.util.Vector;

public class Main {
    public int[] nextGreaterElements(int[] nums) {
        //先求没有循环右边最大的元素
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                    ans[stack.pop()] = i;
                }
                stack.push(i);
            }
        }
        if (!stack.isEmpty()) {
            int end = stack.peek();
            int count = 0;
            int i = (end + 1) % nums.length;
            while (count < nums.length && !stack.isEmpty()) {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    ans[stack.pop()] = i;
                }
                count++;
                i = (i + 1) % nums.length;
            }
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        
    }
}
