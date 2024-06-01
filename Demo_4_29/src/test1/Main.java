package test1;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            boolean flag = false;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) >= '0' && str.charAt(j) <= '9' && flag == false) {
                    flag = true;
                }
                if (str.charAt(j) >= 'A' && str.charAt(j) <= 'Z' && flag == true) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                out.println(transformRXCY(str));
            } else {
                out.println(transformExcel(str));
            }


        }
        out.close();
    }

    public static String transformRXCY(String str) {
        String temp = null;
        long row = 0;
        long col = 0;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) >= '0' && str.charAt(j) <= '9') {
                temp = str.substring(0, j);
                row = Long.parseLong(str.substring(j, str.length()));
                break;
            }
        }
        int k = 0;
        while (temp != null && k < temp.length()) {
            col = col * 26 + (long) (temp.charAt(k) - 65 + 1);
            k++;
        }

        return "R" + row + "C" + col;
    }

    public static String transformExcel(String str) {
        long row = 0;
        long col = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == 'C') {
                row = Long.parseLong(str.substring(1, i));
                col = Long.parseLong(str.substring(i + 1, str.length()));
            }
        }
        StringBuilder ans = new StringBuilder();
        //没有表示0的字母
        while (col > 0) {
            long k = col % 26;
            if (k > 0) {
                ans.append((char) (k + 64));
                col /= 26;
            } else {
                ans.append('Z');
                col = col / 26 - 1;//没法表示0,那么会多一个26去替代0,除26会多一个1
            }
        }
        ans.reverse();
        return ans.toString() + row;
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