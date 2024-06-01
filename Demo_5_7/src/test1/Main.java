package test1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        out.println(new Main().isTriangle(array));
        out.close();
    }

    public String isTriangle(int[] arr) {
        dfs(arr, 0, 3);
        for (int i = 0; i < result.size(); i++) {
            int a = result.get(i).get(0);
            int b = result.get(i).get(1);
            int c = result.get(i).get(2);
            if (a + b > c && a + c > b && b + c > a) {
                if (Math.abs(a - b) < c && Math.abs(a - c) < b && Math.abs(b - c) < a) {
                    return "TRIANGLE";
                }
            }
        }
        for (int i = 0; i < result.size(); i++) {
            int a = result.get(i).get(0);
            int b = result.get(i).get(1);
            int c = result.get(i).get(2);
            if (a + b >= c && a + c >= b && b + c >= a) {
                return "SEGMENT";
            }
        }
        return "IMPOSSIBLE";
    }

    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> result = new ArrayList<>();

    public void dfs(int[] arr, int startIndex, int k) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < arr.length - (k - path.size()) + 1; i++) {
            path.add(arr[i]);
            dfs(arr, i + 1, 3);
            path.remove(path.size() - 1);
        }
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