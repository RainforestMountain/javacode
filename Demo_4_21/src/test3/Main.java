package test3;

import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        HashMap<Character, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String src = scanner.nextLine();
            char ch = src.charAt(0);
            if (map.containsKey(ch)) {
                map.get(ch).add(src);
            } else {
                map.put(ch, new ArrayList<>());
                map.get(ch).add(src);
            }
        }

        int k = scanner.nextInt();
        String str = scanner.nextLine();
        int fast = 0;
        int slow = 0;
//        for (; fast < str.length(); fast++) {
//            if (map.containsKey(str.charAt(fast))) {
//                List<String> temp = map.get(str.charAt(0));
//                for (int i = 0; i < temp.size(); i++) {
//                    int len = temp.get(i).length();
//                    if (str.substring(fast,fast + len).equals(temp.get(i))) {
//                        str.replaceAll()
//                    }
//                }
//            }
//        }
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

