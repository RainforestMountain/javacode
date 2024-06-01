package test2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        for (int c = 0; c < t; c++) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = scanner.nextInt();
            }
            if (n == 1) {
                out.println(1);
                continue;
            }
            //动态规划记忆化存储
            int[][] dp = new int[n][n];
            for (int i = 0; i < dp.length; i++) {
                dp[i][i] = array[i];
            }
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    if (j - i + 1 < 3) {
                        dp[i][j] = array[i] | array[j];
                    } else {
                        dp[i][j] = (array[i] | dp[i + 1][j - 1]) | array[j];
                    }
                }
            }
            int k = 1;
            boolean flag = true;
            for (; k <= n; k++) {
                flag = true;
                for (int i = 1; i <= n - k + 1; i++) {
                    for (int j = i; j <= n - k + 1; j++) {
                        if (dp[i - 1][i + k - 1 - 1] != dp[j - 1][j + k - 1 - 1]) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag == true) {
                    break;
                }
            }
            if (flag == true) {
                out.println(k);
            } else {
                out.println(-1);
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
