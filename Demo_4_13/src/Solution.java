import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<Integer, String> map = new HashMap<>();
    StringBuilder s = new StringBuilder();
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        initMap();
        dfs(digits, 0);
        return ans;
    }

    public void initMap() {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    public void dfs(String digits, int index) {
        if (s.length() == digits.length()) {
            ans.add(s.toString());
            return;
        }

        int boundary = Integer.parseInt(digits.charAt(index) + "");
        String str = map.get(boundary);
        for (int i = 0; i < str.length(); i++) {
            s.append(str.charAt(i));
            dfs(digits, index + 1);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("234"));
    }
}
