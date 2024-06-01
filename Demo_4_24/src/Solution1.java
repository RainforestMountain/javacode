public class Solution1 {
    public String solve (String s, String t) {
        // write code here
        int i = s.length() - 1;
        int j = t.length() - 1;
        StringBuilder ans = new StringBuilder();
        int c = 0;
        //处理要运算的各种情况
        while (i >= 0 || j >= 0 || c != 0) {
            if (i >=  0) {
                c += s.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                c += t.charAt(j) - '0';
                j--;
            }
            ans.append((char)(c % 10 + '0'));
            c = c /10;
        }
        return ans.reverse().toString();
    }
}
