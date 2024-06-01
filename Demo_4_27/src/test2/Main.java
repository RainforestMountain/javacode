package test2;

import javax.security.auth.callback.CallbackHandler;
import java.time.temporal.JulianFields;
import java.util.*;
import java.io.*;


// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
    static Read scanner = new Read();
    static List<Character> path = new LinkedList<>();
    static List<List<Character>> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        char[] data = scanner.nextLine().toCharArray();
        List<List<Character>> ans = getShyNum(data);
        for (List<Character> val: ans) {
            System.out.println(val);
        }
        out.close();

    }

    public static List<List<Character>> getShyNum(char[] data) {
        dfs(data, 0);
        return result;
    }

    public static void dfs(char[] data, int startIndex) {
        if (path.size() == 3) {
            if (path.get(0) == 's' && path.get(1) == 'h' && path.get(2) == 'y') {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i < data.length; i++) {
            if (data[i] != 's' && data[i] != 'h' && data[i] != 'y') {
                continue;
            }
            //把递归和回溯写在添加元素外面,容易导致每天加元素也删除了
            if (data[i] == 's' && path.size() == 0) {
                path.add(data[i]);
                dfs(data, i + 1);
                if (!path.isEmpty()) {
                    path.remove(path.size() - 1);
                }
            }

            if (data[i] == 'h' && path.size() == 1) {
                path.add(data[i]);
                dfs(data, i + 1);
                if (!path.isEmpty()) {
                    path.remove(path.size() - 1);
                }
            }

            if (data[i] == 'y' && path.size() == 2) {
                path.add(data[i]);
                dfs(data, i + 1);
                if (!path.isEmpty()) {
                    path.remove(path.size() - 1);
                }
            }
//            path.add(data[i]);
//            dfs(data, i + 1);
//            if (!path.isEmpty()) {
//                path.remove(path.size() - 1);
//            }
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

    Long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    Double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

}
