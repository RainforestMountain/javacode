package test1;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int N = scanner.nextInt();
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = scanner.nextLine();
        }
        int k = scanner.nextInt();
        StringBuilder src = new StringBuilder(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
//            while (src.toString().contains(strings[i])) {
//                int j = kmp(src, strings[i]);
//                src.replace(j, j + strings[i].length(), "<censored>");
//                count++;
//            }
            while (true) {
                int j = kmp(src, strings[i]);
                if (j == -1) {
                    break;
                } else {
                    src.replace(j, j + strings[i].length(), "<censored>");
                    count++;
                }
            }


        }
        if (count >= k) {
            out.println(count);
            out.println("He Xie Ni Quan Jia!");
        } else {
            out.print(src);
        }
        out.close();
    }

    public static int[] getNext(String t) {
        int j = 0;
        int[] next = new int[t.length()];
        for (int i = 1; i < t.length(); i++) {
            while (j > 0 && t.charAt(i) != t.charAt(j)) {
                j = next[j - 1];
            }
            if (t.charAt(i) == t.charAt(j)) {
                j++;
                next[i] = j;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }

    public static int kmp(StringBuilder s, String t) {
        int[] next = getNext(t);
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            //由于是回退到next[j - 1]为了使下标合法,要进行多次判断
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && s.charAt(i) != t.charAt(j)) {
                j = next[j - 1];
            } else {
                i++;
            }
        }
        if (j >= t.length()) {
            return i - t.length();
        }
        return -1;
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