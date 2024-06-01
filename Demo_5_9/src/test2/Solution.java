package test2;

import java.util.HashSet;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int len = 0;
        HashSet<Character> set = new HashSet<>();
        for (; left < s.length(); left++) {
            while (right < s.length() &&!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            len = Math.max(len, right - left);
            if (right == s.length()) {
                return len;
            }
            set.remove(s.charAt(left));
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("bbbbbb"));
    }

}
