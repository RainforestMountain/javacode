package test1;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        //贪心,棋手分数
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int p1 = scanner.nextInt();
            int p2 = scanner.nextInt();
            int p3 = scanner.nextInt();
            int x = 0;
            int y = 0;
            int z = 0;
            if ((p1 + p2 + p3) % 2 != 0) {
                out.println(-1);
                continue;
            }
            int sum_xz = (p1 + p2 + p3) / 2;
            boolean flag = false;
            for (z = sum_xz; z >= 0; z--) {
                x = sum_xz - z;
                int temp = p3 - 2 * x;
                if (temp < 0) {
                    continue;
                }
                periphery:
                for (int z12 = 0; z12 <= z; z12++) {
                    for (int z13 = 0; z13 <= z; z13++) {
                        for (int z23 = 0; z23 <= z; z23++) {
                            if (z12 + z13 + z23 == z) {
                                if (z12 + z13 == p1 && z12 + z23 == p2 && z23 + z13 == temp) {
                                    flag = true;
                                    break periphery;
                                }
                            }
                        }
                    }
                }
                if (flag == true) {
                    out.println(z);
                    break;
                }
            }
            if (flag == false) {
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
