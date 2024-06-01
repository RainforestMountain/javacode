package test4;

import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        List<List<Integer>> books = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = scanner.nextInt();
            int s = scanner.nextInt();
            int w = scanner.nextInt();
            books.add(Arrays.asList(h, s, w));
        }
        Collections.sort(books, (o1, o2) -> {
            if (o1.get(0) > o2.get(0)) {
                return -1;
            } else if (o1.get(0) < o2.get(0)) {
                return 1;
            } else {
                if (o1.get(1) > o2.get(1)) {
                    return -1;
                } else if (o1.get(1) < o2.get(1)) {
                    return 1;
                } else {
                    return o2.get(2) - o1.get(2);
                }
            }
        });

        for (List<Integer> book : books) {
            out.println(book.get(0) + " " + book.get(1) + " " + book.get(2));
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