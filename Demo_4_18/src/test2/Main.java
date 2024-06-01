package test2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.*;
public class Main {
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static Read in = new Read();
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        int N = in.nextInt();
        for (int i = 0; i <= N; i++) {
            String str = in.nextLine();
            String[] strings = str.split(" ");
            switch (strings[0]) {
                case "Pop": {
                    if (stack.isEmpty()) {
                        out.println("Invalid");
                        out.flush();

                    } else {
                        out.println(stack.pop());
                        out.flush();
                    }
                    break;
                }
                case "Push": {
                    int value = Integer.parseInt(strings[1]);
                    stack.push(value);
                    break;
                }
                case "PeekMedian": {
                    if (stack.isEmpty()) {
                        out.println("Invalid");
                        out.flush();
                    } else {
                        Integer[] array = stack.toArray(new Integer[0]);
                        Arrays.sort(array);
                        out.println(array[(array.length - 1) / 2]);
                        out.flush();
                    }
                    break;
                }
            }
        }
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

