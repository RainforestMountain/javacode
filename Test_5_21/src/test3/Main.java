package test3;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String b = scanner.next();
            char[] array = b.toCharArray();
            TreeSet<Character> set = new TreeSet<>();
            for (int j = 0; j < b.length(); j++) {
                set.add(b.charAt(j));
            }
            char[] path = new char[set.size()];
            int k = 0;
            for (Character val : set) {
                path[k] = val;
                k++;
            }
            int left = 0;
            int right = path.length - 1;
            HashMap<Character, Character> map = new HashMap<>();
            while (left <= right) {
                map.put(path[left], path[right]);
                map.put(path[right], path[left]);
                left++;
                right--;
            }
            for (int j = 0; j < array.length; j++) {
                char ch = array[j];
                array[j] = map.get(ch);
            }
            for (char val : array) {
                out.print(val);
            }
            out.println();
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
