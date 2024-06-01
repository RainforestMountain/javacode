package test1;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static Read in = new Read();

    static HashSet<String> result = new HashSet<>();

    public static HashSet<String> deleteChar(String src) {
        dfs(new StringBuilder(src), 0, 3);
        return result;
    }

    public static void dfs(StringBuilder src, int startIndex, int k) {
        result.add(src.toString());
        if (k == 0) {
            return;
        }
        for (int i = startIndex; i < src.length(); i++) {
            char temp = src.charAt(i);
            src.deleteCharAt(i);
            dfs(src, i, k - 1);
            src.insert(i, temp);
        }
    }
    public static void main(String[] args) throws IOException {
        String str = in.nextLine();
        out.print(deleteChar(str).size());
        out.close();
    }

}

class Read // 自定义快速读入
{
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
