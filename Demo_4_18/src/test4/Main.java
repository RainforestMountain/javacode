package test4;

import java.util.*;
import java.io.*;
public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException{
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] sum = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        sum[0] = nums[0];
        for(int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int left = 0;
        int right = 0;
        int minLen = n;
        int i = 0;
        int temp = 0;
        for (int j = 0; j < sum.length; j++) {
            if (i == 0) {
                temp = sum[j];
            } else {
                temp = sum[j] - sum[i - 1];
            }
            while (temp >= x) {
                int tempLen = j - i + 1;
                if (tempLen < minLen) {
                    minLen = tempLen;
                    left = i;
                    right = j;
                }
                i++;
                temp = sum[j] - sum[i - 1];
            }
        }
        out.println((left + 1) + " " + (right + 1));
        out.close();
    }
}

class Read {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    String next() throws IOException {
        while(!st.hasMoreTokens()) {
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

    Double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
