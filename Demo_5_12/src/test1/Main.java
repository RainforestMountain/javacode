package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map1.put(p.charAt(i), map1.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int len = 0;
        for (; right < s.length(); right++) {
            map2.put(s.charAt(right), map2.getOrDefault(s.charAt(right), 0) + 1);
            len++;
            if (len == p.length()) {
                if (map1.keySet().size() == map2.keySet().size() && map1.equals(map2)) {
                    result.add(left);
                }
                map2.put(s.charAt(left),map2.get(s.charAt(left)) - 1);
                if (map2.get(s.charAt(left)) == 0) {
                    map2.remove(s.charAt(left));
                }
                left++;
                len--;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        int c = map.get(1) - 1;
        System.out.println(map);

    }
}
