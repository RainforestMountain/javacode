package test1;

import java.io.*;
import java.util.*;

public class Main {

    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            HashMap<Integer, Integer> cardMap = new HashMap<>();
            HashMap<Integer, List<Integer>> countMap = new HashMap<>();
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                int c = scanner.nextInt();
                cardMap.put(c, cardMap.getOrDefault(c, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : cardMap.entrySet()) {
                if (!countMap.containsKey(entry.getValue())) {
                    countMap.put(entry.getValue(), new ArrayList<>());
                    countMap.get(entry.getValue()).add(entry.getKey());
                } else {
                    countMap.get(entry.getValue()).add(entry.getKey());
                }
            }
            int maxCount = 0;
            for (Map.Entry<Integer, Integer> entry : cardMap.entrySet()) {
                maxCount = Math.max(entry.getValue(), maxCount);
            }

            while (true) {
                boolean jude = false;
                //减
                for (int j = k; j <= maxCount; j++) {
                    if (countMap.containsKey(j) && !countMap.get(j).isEmpty()) {
                        Integer remove = countMap.get(j).remove(countMap.get(j).size() - 1);
                        if (!countMap.containsKey(j - k)) {
                            countMap.put(j - k, new ArrayList<>());
                            countMap.get(j - k).add(remove);
                        } else {
                            countMap.get(j - k).add(remove);
                        }
                        cardMap.put(remove, j - k);
                        jude = true;
                        break;
                    }
                }
                if (jude == true) {
                    //加
                    int num = k - 1;
                    for (int j = k - 1; j >= 0; j--) {
                        //从k - 1开始加
                        if (countMap.containsKey(j) && !countMap.get(j).isEmpty()) {
                            int size = countMap.get(j).size();
                            for (int p = 0; p < size; p++) {
                                Integer val = countMap.get(j).remove(countMap.get(j).size() - 1);
                                int count = j + (Math.min(num, k - j));
                                num -= k - j;
                                if (!countMap.containsKey(count)) {
                                    countMap.put(count, new ArrayList<>());
                                    countMap.get(count).add(val);
                                } else {
                                    countMap.get(count).add(val);
                                }
                                cardMap.put(val, count);
                                if (num <= 0) {
                                    break;
                                }
                            }
                        }
                        if (num <= 0) {
                            break;
                        }
                    }
                }


                boolean flag = false;
                for (Map.Entry<Integer, Integer> entry : cardMap.entrySet()) {
                    if (entry.getValue() >= k) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    break;
                }

            }
            int ans = 0;
            for (Map.Entry<Integer, Integer> entry : cardMap.entrySet()) {
                ans += entry.getValue();
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
}
