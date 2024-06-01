package test2;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        int ret = 0;
        while (check(list)) {
            int val = list.remove(list.size() - 1);
            list.add(0,val);
            ret++;
            if (ret == k) {
                out.println("Yes");
                out.close();
                return;
            }
        }
        ret = 0;

        while (check(list)) {
            int val = list.remove(0);
            list.add(val);
            ret++;
            if (ret == k) {
                out.println("Yes");
                out.close();
                return;
            }
        }
        if (ret < k) {
            out.println("No");
        }
        out.close();

    }

    public static boolean check(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == i + 1) {
                return true;
            }
        }
        return false;
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