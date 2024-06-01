package test4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = scanner.nextInt();
            }
            List<int[]> path = new ArrayList<>();

            for (int j = 0; j < nums.length - 2; j++) {
                path.add(new int[]{nums[j], nums[j + 1], nums[j + 2]});
            }
            int count = 0;

            for (int j = 0; j < path.size(); j++) {
                for (int k = j + 1; k < path.size(); k++) {
                    int[] arr1 = path.get(j);
                    int[] arr2 = path.get(k);
                    if (arr1[0] != arr2[0] && arr1[1] == arr2[1] && arr1[2] == arr2[2]) {
                        count++;
                    } else if (arr1[0] == arr2[0] && arr1[1] != arr2[1] && arr1[2] == arr2[2]) {
                        count++;
                    } else if (arr1[0] == arr2[0] && arr1[1] == arr2[1] && arr1[2] != arr2[2]) {
                        count++;
                    }
                }
            }
            out.println(count);
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
