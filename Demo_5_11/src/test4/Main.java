package test4;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String src = scanner.nextLine();
            if (src.length() == 1) {
                out.println(1);
            } else {
                int split = 0;
                int cur = 1;
                int pre = 0;
                while (cur < src.length()) {
                    if (src.charAt(pre) == '1' && src.charAt(cur) == '0') {
                        split++;
                    }
                    cur++;
                    pre++;
                }
                out.println(split + 1);
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