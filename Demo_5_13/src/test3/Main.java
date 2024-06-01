package test3;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<String> path = new LinkedList<>();
        List<String> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            path.add(scanner.next());
        }
        int cur = 0;
        boolean[] flag = new boolean[n];
        Arrays.fill(flag, true);
        for (int j = 0; j < m; j++) {
            int size = path.size();
            String tmp = scanner.next();
            if (tmp.equals(path.get(cur))) {
                if (flag[cur] == false) {
                    flag[cur] = true;
                } else {
                    String remove = path.remove(cur);
                    result.add(0,remove);
                }
                cur = (cur + 1) % size;
            } else {
                flag[cur] = false;
            }
        }

        for (String s : result) {
            out.println(s);
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