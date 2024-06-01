package test10;

import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
//        int N = scanner.nextInt();
//        HashMap<StringBuilder, String> map = new HashMap<>();
//        for (int i = 0; i < N; i++) {
//            String str = scanner.nextLine();
//            String[] strings = str.split(" ");
//            StringBuilder ans = new StringBuilder();
//            for (int j = 0; j < strings.length; j++) {
//                ans.append(Character.toUpperCase(strings[j].charAt(0)));
//            }
//            map.put(ans, str);
//        }
//        int M = scanner.nextInt();
//        for (int i = 0; i < M; i++) {
//            String src = scanner.nextLine();
//            String[] strings = src.split(" ");
//            StringBuilder ans = new StringBuilder();
//            for (int j = 0; j < strings.length; j++) {
//                ans.append(Character.toUpperCase(strings[j].charAt(0)));
//            }
//            if (map.containsKey(ans)) {
//                out.println(map.get(ans));
//            } else {
//                out.println(src);
//            }
//        }
//        out.close();

        HashMap<String,String> map = new HashMap<>();
        map.put("上海","阿里");
        System.out.println(map.get(new String("上海")));
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

