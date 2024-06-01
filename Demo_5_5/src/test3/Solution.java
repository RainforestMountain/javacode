package test3;

import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        String src = String.valueOf(n);
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        //不是快乐数,sum会循环
        while (sum != 1) {
            sum = 0;
            for (int i = 0; i < src.length(); i++) {
                int temp = src.charAt(i) - '0';
                sum += temp * temp;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
            src = String.valueOf(sum);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(3));
    }
}
