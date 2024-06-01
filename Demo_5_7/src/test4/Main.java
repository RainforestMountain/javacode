package test4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        double[][] probability = new double[n][n];
        for (int i = 0; i < probability.length; i++) {
            for (int j = 0; j < probability[i].length; j++) {
                probability[i][j] = scanner.nextDouble();
            }
        }
        double[] dp = new double[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < probability.length; i++) {
            for (int j = 0; j < probability.length; j++) {
                if (i != j) {
                    dp[i] *= probability[i][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            out.printf("%.6f ", dp[i]);
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
