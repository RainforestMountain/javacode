package test11;

import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int N = scanner.nextInt();
        UnionFindSet ufs = new UnionFindSet(99999);
        char[] sexs = new char[N + 1];
        for (int i = 0; i < N; i++) {
            int id = Integer.parseInt(scanner.next());
            ufs.elem[id] = -1;
            char sex = scanner.next().charAt(0);
            int fatherId = Integer.parseInt(scanner.next());
            int motherId = Integer.parseInt(scanner.next());
            if (fatherId != -1) {
                ufs.elem[fatherId] = -1;
                ufs.merge(id, fatherId);
            }
            if (motherId != -1) {
                ufs.elem[motherId] = -1;
                ufs.merge(id, motherId);
            }
            sexs[id] = sex;
        }
        int K = scanner.nextInt();
        for (int i = 0; i < K; i++) {
            int id1 = Integer.parseInt(scanner.next());
            int id2 = Integer.parseInt(scanner.next());
            if (sexs[id1] == sexs[id2]) {
                out.println("Never Mind");
            } else {
                if (ufs.findConnection(id1, id2)) {
                    out.println("No");
                } else {
                    out.println("Yes");
                }
            }
        }
        out.close();
    }


}

class UnionFindSet {
    public int[] elem;

    public UnionFindSet(int n) {
        elem = new int[n + 1];
        Arrays.fill(elem, -2000);
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

    public boolean findConnection(int x1, int x2) {
        if (!isSameSet(x1, x2)) {
            return false;
        }
        List<Integer> ans = new ArrayList<>();
        while (elem[x1] >= 0) {
            ans.add(elem[x1]);
            x1 = elem[x1];
        }
        int h1 = 0;
        int h2 = 0;
        while (elem[x2] >= 0) {
            if (ans.contains(elem[x2])) {
                h1 = ans.indexOf(elem[x2]) + 1;
            }
            h2++;
        }
        int max = Math.max(h1, h2);
        if (max >= 4) {
            return false;
        } else {
            return true;
        }

    }

    public boolean merge(int x1, int x2) {
        int root1 = find(x1);
        int root2 = find(x2);
        if (root1 == root2) {
            return false;
        }
//        if (elem[root1] == -2000 && elem[root2] != -2000) {
//            elem[root1] = elem[root2] - 1;
//        } else if (elem[root1] != -2000 && elem[root2] == -2000) {
//
//        }
        elem[root1] = elem[root1] + elem[root2];
        elem[root2] = root1;
        return true;
    }

    public boolean isSameSet(int x1, int x2) {
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
            if (elem[i] < 0 && elem[i] != -2000) {
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

