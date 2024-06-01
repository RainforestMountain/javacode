package test4;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        double[] prices = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            prices[i] = scanner.nextDouble();
        }
        int[] counts = new int[n + 1];

        while (true) {
            int num = scanner.nextInt();
            int m = scanner.nextInt();
            if (num == 0) {
                break;
            }
            counts[num] = counts[num] + m;
        }

        for (int i = 1; i <= n; i++) {
            out.println(counts[i]);
        }
        double sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum = sum + prices[i] * counts[i];
        }
        out.printf("%.2f", sum);
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