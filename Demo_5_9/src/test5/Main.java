package test5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {


        int t = scanner.nextInt();
        for (int j = 0; j < t; j++) {
            HashMap<Integer, int[]> map = new HashMap<>();
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                int val = scanner.nextInt();
                if (!map.containsKey(val)) {
                    map.put(val, new int[]{1, i + 1});
                } else {
                    int count = map.get(val)[0] + 1;
                    map.put(val, new int[]{count, i + 1});

                }
            }
            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                if (entry.getValue()[0] == 1) {
                    out.println(entry.getValue()[1]);
                }
            }
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

