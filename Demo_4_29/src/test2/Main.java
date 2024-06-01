package test2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            String[] strings = str.split(" ");
            map.put(strings[1], strings[2]);
        }

        String src = scanner.nextLine();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        boolean flag = true;
        for (Map.Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value.charAt(0) == '(') {
                flag = true;
            } else if (value.charAt(1) == '*' || value.charAt(1) == '/') {
                flag = true;
            } else {
                if (src.length() == key.length()) {
                    out.println("OK");
                    break;
                }
                int index = kmp(src, key);

            }
        }

    }

    public static int kmp(String s, String t) {
        int[] next = getNext(t);
        int j = 0;
        int i = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else if (s.charAt(i) != t.charAt(j) && j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }
        }
        if (j == t.length()) {
            return i - t.length();
        } else {
            return -1;
        }
    }

    public static int[] getNext(String t) {
        int j = 0;
        int[] next = new int[t.length()];
        for (int i = 1; i < t.length(); i++) {
            while (j > 0 && t.charAt(j) != t.charAt(i)) {
                j = next[j - 1];
            }
            if (t.charAt(i) == t.charAt(j)) {
                j++;
                next[i] = j;
            }
        }
        return next;
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
