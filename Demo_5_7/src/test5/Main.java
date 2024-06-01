package test5;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        for (int c = 0; c < t; c++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            long[] nums = new long[n];
            long[][] dp = new long[n + 1][k + 1];
            dp[0][0] = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextLong();
            }
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    long min = Long.MAX_VALUE;
                    for (int d = 0; j + d <= k && i + d < n; d++) {
                        min = Math.min(min, nums[i + d]);
                        if (dp[i + d + 1][j + d] == 0) {
                            dp[i + d + 1][j + d] = dp[i][j] + (d + 1) * min;
                        } else {
                            dp[i + d + 1][j + d] = Math.min(dp[i][j] + (d + 1) * min, dp[i + d + 1][j + d]);
                        }

                    }
                }
            }
            out.println(dp[n][k]);
            out.flush();
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
