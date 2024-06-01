package test6;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int r = scanner.nextInt();
            if (r == 1) {
                out.println(1);
            } else {
                //固定x,枚举y
                //从 x + y = r,往上枚举
                //直到x >= r + 1即可
                int count = 0;
                for (int x = 0; x < r; x++) {
                    for (int y = r - x; x * x + y * y < (r + 1) * (r + 1); y++) {
                        if (x * x + y * y >= r * r) {
                            count++;
                        }
                    }
                }
                out.println(count * 4);
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
}
