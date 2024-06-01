package test5;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    static PrintWriter out = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        Lady[] ladies = new Lady[n];
        for (int i = 0; i < ladies.length; i++) {
            ladies[i] = new Lady(i, scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(ladies, new Comparator<Lady>() {
            @Override
            public int compare(Lady o1, Lady o2) {
                if (o1.num1 > o2.num1) {
                    return 1;
                } else if (o1.num1 < o2.num1) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        long max = (long) 1e9 + 1;

    }
}

class Lady {
    int id;
    long num1;
    long num2;
    long num3;

    Lady(int id, long num1, long num2, long num3) {
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
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