import java.util.Locale;

public class Solution {
    public int countSegments(String s) {
        int count = 0;
        if (s.isEmpty() || s.charAt(0) == ' ') {
            return count;
        }
        int serialCount = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                flag = true;
                serialCount++;
            }
            if (s.charAt(i) == ' ') {
                flag = false;
            }

            if (flag == false) {
                if (serialCount != 0) {
                    count++;
                    serialCount = 0;
                }
            }
        }
        if (s.charAt(s.length() - 1) != ' ') {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSegments("Of all " +
                "the gin joints in all the towns in all the world,   "));
    }
}
