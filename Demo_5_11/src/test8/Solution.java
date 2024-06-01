package test8;

import java.util.HashMap;

public class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            if (map.size() >= 3) {
                count = Math.max(count, right - left);
                while (map.size() >= 3) {
                    if (map.get(fruits[left]) <= 1) {
                        map.remove(fruits[left]);
                    } else {
                        map.put(fruits[left], map.get(fruits[left]) - 1);
                    }
                }
            }
        }
        if (count == 0) {
            return fruits.length;
        } else {
            return count;
        }
    }
}
