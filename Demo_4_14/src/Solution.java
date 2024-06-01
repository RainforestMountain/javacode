import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> path = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return result;
    }

    public void backTracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String temp = s.substring(startIndex, i + 1);
            if (isReverse(temp)) {
                path.add(temp);
                backTracking(s, i + 1);
                path.remove(path.size() - 1);
            } else {
                continue;
            }

        }
    }

    public boolean isReverse(String s) {

        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("aabcb"));
    }
}
