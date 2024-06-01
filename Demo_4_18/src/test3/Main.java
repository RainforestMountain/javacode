package test3;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;
import java.io.*;


public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Integer[] values = new Integer[N];
        for (int i = 0; i < N; i++) {
            values[i] = scanner.nextInt();
        }
        Arrays.sort(values, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        out.println(Arrays.toString(values));
        int[][] dp = new int[N][M + 1];
        int[][] vis = new int[N][M + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            if (j >= values[0]) {
                dp[0][j] = values[0];
                vis[0][j] = 1;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j < values[i]) {
                    dp[i][j] = dp[i - 1][j];
                    vis[i][j] = 0;
                } else {
                    if (dp[i - 1][j - values[i]] + values[i] >= dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][j - values[i]] + values[i];
                        vis[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                        vis[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            out.print(i + " : ");
            out.println(Arrays.toString(dp[i]));
        }
        out.flush();
        out.println();
        for (int i = 0; i < vis.length; i++) {
            out.print(i + " : ");
            out.println(Arrays.toString(vis[i]));
        }
        out.flush();
        List<Integer> list = new ArrayList<>();

        int i = N - 1;
        int v = M;
        //能达到目标和
        boolean flag = false;
        for (int j = 0; j < dp.length; j++) {
            if (dp[j][M] == M) {
                flag = true;
            }
        }

        if (flag) {
            while (v > 0 && i >= 0) {
                if (vis[i][v] == 1) {
                    list.add(values[i]);
                    v -= values[i];
                }
                i--;
            }
            Collections.sort(list);
            for (int k = 0; k < list.size(); k++) {
                if (k == list.size() - 1) {
                    out.print(list.get(k));
                } else {
                    out.print(list.get(k) + " ");
                }
            }
        } else {
            out.print("No Solution");
        }

        out.close();
    }
}

class Read {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        String s = st.nextToken();
        return s;
    }

    String nextLine() throws IOException {
        return bf.readLine();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    Long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }


}
