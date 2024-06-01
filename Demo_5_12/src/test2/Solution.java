package test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < words[0].length()) {
            return result;
        }
        int left = 0;
        int right = 0;//移动多步
        HashMap<String, Integer> map1 = new HashMap<>();//统计words字符串出现的次数

        for (String word : words) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }
        int len = words[0].length();
        StringBuilder src = new StringBuilder(s);
        for (int i = 0; i < len; i++) {
            HashMap<String, Integer> map2 = new HashMap<>();//统计s字符串出现的次数
            int count = 0;//统计map2中有效字符串的个数
            left = i;
            for (right = left + len - 1; right < src.length(); right += len) {
                //进窗口
                String tmp = src.substring(right + 1 - len, right + 1);
                map2.put(tmp, map2.getOrDefault(tmp, 0) + 1);
                //统计有效字符个数
                if (map1.containsKey(tmp) && map2.get(tmp) <= map1.get(tmp)) {
                    count++;
                }
                if ((right - left + 1) / len == words.length) {
                    if (count == words.length) {
                        result.add(left);
                    }
                    tmp = src.substring(left, left + len);
                    if (map1.containsKey(tmp) && map2.get(tmp) <= map1.get(tmp)) {
                        count--;
                    }
                    map2.put(tmp, map2.get(tmp) - 1);
                    left = left + len;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubstring("barfoofoobarthefoobarman",
                new String[]{"bar","foo","the"}));
        ;
    }
}
