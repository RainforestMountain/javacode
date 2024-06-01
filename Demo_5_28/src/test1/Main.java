package test1;


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = scanner.nextInt();
            }
            int[] dp = new int[n + 1];
            for (int j = 1; j < dp.length; j++) {
                dp[j] = dp[j - 1] + nums[j - 1];
            }
            for (int j = 0; j < q; j++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                out.println(dp[r] - dp[l - 1]);
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

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
