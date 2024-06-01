package test1;

import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            //数组作为二元组,HashMap对于数组作为key是比较引用,而list是比较具体的元素,内容
            HashMap<List<Integer>, Integer> map1 = new HashMap<>();
            HashMap<List<Integer>, Integer> map2 = new HashMap<>();
            HashMap<List<Integer>, Integer> map3 = new HashMap<>();
            HashMap<List<Integer>, Integer> three = new HashMap<>();
            int ans = 0;
            for (int j = 0; j < nums.length - 2; j++) {
                //先计算出多个三元组中3个二元组分别相等的情况
                List<Integer> list1 = Arrays.asList(nums[j], nums[j + 1]);
                List<Integer> list2 = Arrays.asList(nums[j], nums[j + 2]);
                List<Integer> list3 = Arrays.asList(nums[j + 1], nums[j + 2]);
                List<Integer> list4 = Arrays.asList(nums[j], nums[j + 1], nums[j + 2]);
                ans += (map1.get(list1) == null ? 0 : map1.get(list1))
                        + (map2.get(list2) == null ? 0 : map2.get(list2))
                        + (map3.get(list3) == null ? 0 : map3.get(list3));
                map1.put(list1, map1.getOrDefault(list1, 0) + 1);
                map2.put(list2, map2.getOrDefault(list2, 0) + 1);
                map3.put(list3, map3.getOrDefault(list3, 0) + 1);
                //去掉多个三元组完全相等的情况
                if (three.get(list4) != null) {
                    ans -= three.get(list4) * 3;
                }
                three.put(list4, three.getOrDefault(list4, 0) + 1);
            }
            out.println(ans);
        }
        out.close();
    }
}


class Read {
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    String nextLine() throws IOException {
        return bf.readLine();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}