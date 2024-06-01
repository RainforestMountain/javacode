package test6;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int[][] arrray = new int[9][9];
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arrray.length; j++) {
                for (int k = 0; k < arrray.length; k++) {
                    arrray[j][k] = scanner.nextInt();
                }
            }
            if (i == n - 1) {
                out.print(isCorrect(arrray));
            } else {
                out.println(isCorrect(arrray));
            }
        }
        out.close();

    }

    public static int isCorrect(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum = sum + array[i][j];
            }
            if (sum != 45) {
                return 0;
            }
        }

        for (int j = 0; j < array.length; j++) {
            sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum = sum + array[i][j];
            }
            if (sum != 45) {
                return 0;
            }
        }

        for (int i = 1; i < array.length; i += 3) {
            sum = 0;
            for (int j = 1; j < array.length; j += 3) {
                sum = array[i - 1][j - 1] + array[i - 1][j] + array[i - 1][j + 1]
                        + array[i][j - 1] + array[i][j] + array[i][j + 1]
                        + array[i + 1][j - 1] + array[i + 1][j] + array[i + 1][j + 1];
                if (sum != 45) {
                    return 0;
                }
            }
        }
        return 1;
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