package test5;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            ans.add(new LinkedList<>());
        }
        int stepCount = 0;
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int maxStep = 0;
        for (int i = a; i <= b; i++) {
            StringBuilder str = new StringBuilder(i + "");
            stepCount = 0;
            while (str.length() > 1) {
                int ret = 1;
                for (int j = 0; j < str.length(); j++) {
                    ret = ret * Integer.parseInt(str.charAt(j) + "");
                }
                stepCount++;
                str.delete(0, str.length());
                str.append(ret);
            }
            maxStep = Math.max(maxStep, stepCount);
            ans.get(stepCount).add(i);
        }
//        for(int i = 0; i < ans.size();i++) {
//            System.out.println(ans.get(i));
//        }
        for(int i = 0; i < ans.get(maxStep).size();i++) {
            if (i == ans.get(maxStep).size() - 1) {
                out.print(ans.get(maxStep).get(i));
            } else {
                out.print(ans.get(maxStep).get(i)+ " ");
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

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}