package test6;

import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] += dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] += dp[i - 1][0] + grid[i][0];
        }
        //获取最大值
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        int maxValue = dp[dp.length - 1][dp[dp.length - 1].length - 1];
        out.println(maxValue);
        //求路径
        List<int[]> path = new ArrayList<>();
        int i = dp.length - 1;
        int j = dp[i].length - 1;
        //回溯到maxValue为0
        while (maxValue > 0) {
            maxValue -= grid[i][j];
            path.add(0, new int[]{i, j});

            //向上
            if (i - 1 >= 0 && dp[i - 1][j] == maxValue) {
                i = i - 1;
                j = j;
            } else if (j - 1 >= 0 && dp[i][j - 1] == maxValue) {//向左
                i = i;
                j = j - 1;
            }

        }
        for (int k = 0; k < dp.length; k++) {
            out.println(Arrays.toString(dp[k]));
        }
        Iterator<int[]> iterator = path.iterator();
        while (iterator.hasNext()) {
            out.println(Arrays.toString(iterator.next()));
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
