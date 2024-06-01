package test3;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long C = scanner.nextLong();
        C = - C;//题目中均为C移动到方程符号变化,特殊处理
        long[] ans = exGcd(A, B);
        long gcd = ans[0];
        if (C % gcd != 0) {
            out.println(-1);
        } else {
            //先求A * X + B * Y = gcd(A,B)的x0,y0,如何求很重要

            //同时乘以C/gcd(A,B)得
            // (A*c/gcd(A,B))*x0+(B*C/gcd(A,B))*y0=C;
            // 令 x1=C/gcd(A,B)*x0  y1=C/gcd(A,B)*y0;
            // 则可得 Ax1+By1=C                                 方程二
            // 这时得出方程的一个解   x1=x0*C/gcd(A,B)     y1=y0*C/gcd(A,B)

            long k = C / gcd;
            //求A * X + B * Y = gcd(A,B)的x0,y0,如何求x0,y0很重要
            //拓展欧基立德定理计算
            long A1 = A / gcd;
            long B1 = B / gcd;
            long x0 = ans[1];
            long y0 = ans[2];
            out.println(k * x0 + " " + k * y0);


        }

        //System.out.println(Arrays.toString(exGcd(5, 7)));
        out.close();

    }

    public static long gcd(long A, long B) {//递归形式 gcd(a,b) = gcd(b , b mod a);
        long r = 1;
        while (r != 0) {
            r = A % B;
            A = B;
            B = r;
        }
        //r == 0,那么B 也为0 ,只有 A 不为0 ,A 是最大公约数,输出A
        return A;
    }


    //gcd(A,B)是A和B的最大公约数,Ax + By = gcd(A,B),exGcd用于求出符合条件的x 和 y,以及最大公约数
    public static long[] exGcd(long A, long B) {
        if (B == 0) {
            long x = 1;
            long y = 0;
            return new long[]{A, x, y};
        }
        long[] ans = exGcd(B, A % B);
        //x = y1,y = x1 - A / B * y1; x1 = y2, y1 = x2 - A /B * y2;依次递归直到最后A == gcd(a,b), B == 0;
        //且下一层A = B,B = A % B;
        long r = ans[0];
        long x = ans[1];
        long y = ans[2];
        long temp = x;
        x = y;
        y = temp - A / B * y;
        return new long[]{r, x, y};
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
