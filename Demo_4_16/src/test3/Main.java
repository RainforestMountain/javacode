package test3;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str1 = scanner.next();
        String str2 = scanner.next();
        String[] strs = new String[n];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = scanner.next();
        }
        System.out.println(getMinDistance(strs, str1, str2));
    }

    public static int getMinDistance(String[] strs, String str1, String str2) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(str1)) {
                map.put(str1, i);
                if (map.containsKey(str2)) {
                    minDistance = Math.min(minDistance, Math.abs(map.get(str1) - map.get(str2)));
                }
            }
            if (strs[i].equals(str2)) {
                map.put(str2, i);
                if (map.containsKey(str1)) {
                    minDistance = Math.min(minDistance, Math.abs(map.get(str1) - map.get(str2)));
                }
            }
        }
        if (!map.containsKey(str1) || !map.containsKey(str2)) {
            return -1;
        }
        return minDistance;
    }
}
