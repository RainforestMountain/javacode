package test5;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();//最终距离
            int k = scanner.nextInt();//有几站
            int q = scanner.nextInt();//查询几次
            int[] station = new int[k + 1];
            int[] times = new int[k + 1];
            double[] v = new double[k];
            for (int j = 1; j <= k; j++) {
                station[j] = scanner.nextInt();
            }

            for (int j = 1; j <= k; j++) {
                times[j] = scanner.nextInt();
            }
            for (int j = 0; j < k; j++) {
                v[j] = 1.0 * (station[j + 1] - station[j]) / (times[j + 1] - times[j]);
            }
            for (int j = 0; j < q; j++) {
                int b = scanner.nextInt();
                int p = binary(station, b);
                if (p == station.length - 1) {
                    out.print(times[p] + " ");
                } else {
                    double minute = times[p] + (b - station[p]) / v[p];
                    out.print((int) minute + " ");
                }
            }
            out.println();
        }
        out.close();
    }

    public static int binary(int[] station, int b) {
        int left = 0;
        int right = station.length - 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (station[mid] < b) {
                left = mid;
            } else if (station[mid] > b) {
                right = mid;
            } else {
                return mid;
            }
        }
        if (station[right] == b) {
            return right;
        } else {
            return left;
        }
    }

//    public static void main(String[] args) {
//            System.out.println(binary(new int[]{0, 4, 7, 10, 15,25}, 25));
//    }

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
