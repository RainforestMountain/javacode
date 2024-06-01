package test2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            String s = scanner.nextLine();
            for (int j = 0; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            }
            if (map.keySet().size() == 1) {
                out.println("NO");
            } else {
                StringBuilder ans = new StringBuilder();
                out.println("YES");
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    int n = entry.getValue();
                    char ch = entry.getKey();
                    for (int j = 0; j < n; j++) {
                        ans.append(ch);
                    }
                }
                if (!ans.toString().equals(s)) {
                    out.println(ans.toString());
                } else {
                    char ch = ans.charAt(0);
                    ans.delete(0, 1);
                    ans.append(ch);
                    out.println(ans);
                }
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
}