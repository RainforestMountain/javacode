package test3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        for (int k = 0; k < t; k++) {
            int m = scanner.nextInt();
            long x = scanner.nextLong();
            long[] cost = new long[m + 1];
            int[] happy = new int[m + 1];
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                cost[j] = scanner.nextLong();
                happy[j] = scanner.nextInt();
                sum += happy[j];
            }

            long[] dp = new long[sum + 1];//dp[j] 有j幸福度最大钱
            Arrays.fill(dp, Integer.MIN_VALUE / 2);
            dp[0] = 0;
            for (int i = 1; i <= m; i++) {//第一月到第 m 月
                //幸福度为0也有钱有月薪,可以不买,不能省略
                for (int j = dp.length - 1; j >= 0; j--) {
                    if (j >= happy[i] && dp[j - happy[i]] - cost[i] >= 0) {
                        //dp[j - happy[i]] >= cost[i] 要买的起happy[i]否则会用较大的负数覆盖初始值负值
                        //应该用一个非负数去覆盖
                        //不买happy[i] 和 买happy[i]
                        dp[j] = Math.max(dp[j], dp[j - happy[i]] - cost[i]);
                    }
                    //发月薪
                    dp[j] += x;
                }
            }
            //out.println(Arrays.toString(dp));
            for (int j = dp.length - 1; j >= 0; j--) {
                if (dp[j] >= 0) {
                    out.println(j);
                    break;
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

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}