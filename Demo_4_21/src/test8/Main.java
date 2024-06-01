package test8;

import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashSet<Integer>[] set = new HashSet[m + 1];
        for (int i = 1; i < m + 1; i++) {
            set[i] = new HashSet<Integer>();
        }
        for (int i = 1; i <= n; i++) {
            int count = scanner.nextInt();
            for (int j = 0; j < count; j++) {
                int stuff = scanner.nextInt();
                set[stuff].add(i);
            }
        }

        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int count = 0;
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            for (Integer v: set[x]) {
                if (set[y].contains(v)) {
                    count++;
                }
            }
            if (i == Q - 1) {
                out.print(count);
            } else {
                out.println(count);
            }

        }
    }
}

class UnionFindeSet {
    public int[] elem;

    public UnionFindeSet(int n) {
        elem = new int[n];
        Arrays.fill(elem, -1);
    }

    public int find(int x) {
        if (x < 0) {
            return -1;
        }
        while (elem[x] >= 0) {
            x = elem[x];
        }
        return x;
    }

    public boolean merge(int x1,int x2) {
        int root1 = find(x1);
        int root2 = find(x2);
        if (root1 == root2) {
            return false;
        }
        elem[root1] = elem[root1] + elem[root2];
        elem[root2] = root1;
        return true;
    }

    public boolean isSameSet(int x1,int x2) {
        int root1 = find(x1);
        int root2 = find(x2);
        if (root1 == root2) {
            return true;
        }
        return false;
    }

    public int getCount() {
        int count = 0;
        for (int i = 0; i < elem.length; i++) {
            if (elem[i] < 0) {
                count++;
            }
        }
        return count;
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

