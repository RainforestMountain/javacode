package test3;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        HashMap<Integer, double[]> map = new HashMap<>();
        map.put(12, new double[]{0, 2});
        map.put(1, new double[]{1, Math.sqrt(3)});
        map.put(2, new double[]{Math.sqrt(3), 1});
        map.put(3, new double[]{2, 0});
        map.put(4, new double[]{Math.sqrt(3), -1});
        map.put(5, new double[]{1, -Math.sqrt(3)});
        map.put(6, new double[]{0, -2});
        map.put(7, new double[]{-1, -Math.sqrt(3)});
        map.put(8, new double[]{-Math.sqrt(3), -1});
        map.put(9, new double[]{-2, 0});
        map.put(10, new double[]{-Math.sqrt(3), 1});
        map.put(11, new double[]{-1, Math.sqrt(3)});


        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            double[] point1 = map.get(a);
            double[] point2 = map.get(b);
            double[] point3 = map.get(c);
            double[] point4 = map.get(d);
            if ((point2[1] - point1[1]) * (point4[0] - point3[0]) == (point2[0] - point1[0]) * (point4[1] - point3[1])) {
                out.println("NO");
            } else {
                double k = ((point2[1] - point1[1]) * (point3[0] - point1[0]) - (point3[1] - point1[1]) * (point2[0] - point1[0])) /
                        ((point4[1] - point3[1]) * (point2[0] - point1[0]) - (point2[1] - point1[1]) * (point4[0] - point3[0]));
                double x = (point4[1] - point3[1]) * k + point3[1];
                double y = (point4[0] - point3[0]) * k + point3[0];
                if (Math.pow(x, 2) + Math.pow(y, 2) > 4) {
                    out.println("NO");
                } else {
                    out.println("YES");
                }
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
}
