package test2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int[] sugar = new int[n];
        for (int i = 0; i < n; i++) {
            sugar[i] = scanner.nextInt();
        }
        int left = 0;
        int right = sugar.length - 1;
        int timeLeft = 0;
        int timeRight = 0;
        int countLeft = 0;
        int countRight = 0;
        while (left <= right) {
            if (left <= right && timeLeft <= timeRight) {
                countLeft++;
                timeLeft += sugar[left];
                left++;
            }
            if (left <= right && timeRight < timeLeft) {
                timeRight += sugar[right];
                countRight++;
                right--;
            }
        }
        out.println(countLeft + " " + countRight);
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