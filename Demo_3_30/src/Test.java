public class Test {
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        int i = 0;
        int j = 0;
        int count = 0;
        StringBuilder ans = new StringBuilder();
        for (; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(j)) {
                count++;
            } else {
                char tmp = str.charAt(j);
                ans.append(count);
                ans.append(tmp);
                count = 1;
                j = i;
            }
        }
        ans.append(count);
        ans.append(str.charAt(j));
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}
