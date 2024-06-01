package test2;

import java.io.*;
import java.util.StringTokenizer;

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
            long[] weight = new long[n];
            long ans = 0;
            for (int j = 0; j < n; j++) {
                weight[j] = scanner.nextInt();
                if (nums[j] == 1) {
                    ans += weight[j];
                }
            }
            long[] prefix = new long[n + 1];
            for (int j = 1; j < prefix.length; j++) {
                prefix[j] = prefix[j - 1] + (nums[j - 1] == 1 ? -weight[j - 1] : weight[j - 1]);
            }
            long fix = 0;
            long min = Integer.MAX_VALUE / 2;
            for (int j = 1; j < prefix.length; j++) {
                min = Math.min(min, prefix[j - 1]);
                fix = Math.max(fix, prefix[j] - min);
            }
            out.println(ans + fix);
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
