package test1;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int screen = y / 2 + (y % 2 == 0 ? 0 : 1);
            int remain = 0;
            int scr_y = 0;
            if (y % 2 == 0) {
                remain = screen * (5 * 3 - 2 * 4);
                x -= remain;
                if (x <= 0) {
                    out.println(screen);
                } else {
                    screen += x / 15 + (x % 15 == 0 ? 0 : 1);
                    out.println(screen);
                }
            } else {
                remain = (Math.max(screen - 1, 0)) * (5 * 3 - 8) + 15 - 4;
                x-= remain;
                if (x <= 0) {
                    out.println(screen);
                } else {
                    screen += x / 15 + (x % 15 == 0 ? 0 : 1);
                    out.println(screen);
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
