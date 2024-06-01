package test12;

import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int N = scanner.nextInt();
        double[][] degree = new double[N][N];
        int M = scanner.nextInt();
        int[] sex = new int[N];
        for (int i = 0; i < M; i++) {
            List<Integer> man = new ArrayList<>();
            List<Integer> woman = new ArrayList<>();
            int k = scanner.nextInt();
            for (int j = 0; j < k; j++) {
                int id = scanner.nextInt();
                if (id >= 0) {
                    man.add(id);
                    sex[id] = 1;
                } else {
                    woman.add(Math.abs(id));
                    sex[Math.abs(id)] = -1;
                }
            }
            for (int m = 0; m < man.size(); m++) {
                for (int w = 0; w < woman.size(); w++) {
                    degree[man.get(m)][woman.get(w)] += 1.0 / k;
                    degree[woman.get(w)][man.get(m)] += 1.0 / k;
                }
            }
        }
        int A = Math.abs(scanner.nextInt());
        int B = Math.abs(scanner.nextInt());
        double maxA = -1;
        List<Integer> listA = new ArrayList<>();
        double maxB = -1;
        List<Integer> listB = new ArrayList<>();
        for (int j = 0; j < degree[A].length; j++) {
            maxA = Math.max(degree[A][j], maxA);
        }
        for (int j = 0; j < degree[A].length; j++) {
            if (degree[A][j] == maxA) {
                listA.add(j);
            }
        }
        for (int j = 0; j < degree[B].length; j++) {
            maxB = Math.max(degree[B][j], maxB);
        }
        for (int j = 0; j < degree[B].length; j++) {
            if (degree[B][j] == maxB) {
                listB.add(j);
            }
        }
        if (degree[A][B] == maxA) {
            out.println(sex[A] * A + " " + sex[B] * B);
        } else {
            for (int i = 0; i < listA.size(); i++) {
                out.println(sex[A] * A + " " + listA.get(i) * sex[listA.get(i)]);
            }
            for (int i = 0; i < listB.size(); i++) {
                out.println(sex[B] * B + " " + listB.get(i) * sex[listB.get(i)]);
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
