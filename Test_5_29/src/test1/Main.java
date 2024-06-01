package test1;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
        }
        Stack<Integer> stack = new Stack<>();//栈顶到栈底单调递减
        int[] l = new int[n + 1];
        //逆序遍历
        for (int i = n; i >= 1; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (nums[i] >= nums[stack.peek()]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                        l[stack.pop()] = nums[i];
                    }
                    stack.push(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            l[stack.pop()] = -1;
        }
        for (int i = 1; i <= n; i++) {
            out.print(l[i] + " ");
        }
        out.println();
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
