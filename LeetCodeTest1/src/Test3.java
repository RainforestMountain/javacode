import java.util.HashSet;

public class Test3 {

    public static int lengthOfLongestSubstring(String s) {

        int m = s.length();
        if (m == 0) {
            return 0;
        }
        int num = 1;  //初始值表示以s的第一个字符为结束的不重复的最长子串
        int max = 1;
        for (int i = 1; i < m; i++) {
            int index = s.indexOf(s.charAt(i), i - num);
            if (index < i) {  //num更新，表示以s的第i+1个字符为结束的不重复的最长子串
                num = i - index;
            } else {
                num = num + 1;
            }
            max = Math.max(max, num);
        }
        return max;

    }

    public static void main(String[] args) {
        int maxLen = lengthOfLongestSubstring("abcabcdebf");
        System.out.println(maxLen);
    }
}
