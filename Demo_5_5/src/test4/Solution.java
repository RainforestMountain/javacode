package test4;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = Math.max(height[left], height[right]) * (right - left);
        while (left < right) {
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
            maxArea = Math.max(maxArea, Math.max(height[left], height[right]) * (right - left));
        }
        return maxArea;
    }
}
