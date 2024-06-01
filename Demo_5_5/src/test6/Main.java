package test6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] BIT = new long[3 * N + 1];
        long ans = 0;

        List<Triplet> ladies = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int iVal = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ladies.add(new Triplet(b, iVal, c));
        }

        Collections.sort(ladies, (a, b) -> {
            if (a.a == b.a) {
                if (a.b == b.b) {
                    return Integer.compare(a.c, b.c);
                }
                return Integer.compare(a.b, b.b);
            }
            return Integer.compare(a.b, b.b);
        });

        int[] idxMap = new int[N];
        for (int i = 0; i < N; i++) {
            idxMap[ladies.get(i).b] = i + 1;
        }

        for (int i = N - 1; i >= 0; i--) {
            Triplet lady = ladies.get(i);
            long cnt = query(BIT, lady.a, lady.b, lady.c);
            ans += cnt;
            update(BIT, lady.a, lady.b, lady.c, 1);
        }

        System.out.println(ans);
    }

    static void update(long[] BIT, int a, int b, int c, int val) {
        for (int i = a; i < BIT.length; i += i & -i) {
            BIT[i] += val;
        }
        b++;
        for (int i = b; i < BIT.length; i += i & -i) {
            BIT[i] += val;
        }
        c++;
        for (int i = c; i < BIT.length; i += i & -i) {
            BIT[i] += val;
        }
    }

    static long query(long[] BIT, int a, int b, int c) {
        long res = 0;
        for (int i = c; i > 0; i -= i & -i) {
            res += BIT[i];
        }
        b--;
        for (int i = b; i > 0; i -= i & -i) {
            res -= BIT[i];
        }
        a--;
        for (int i = a; i > 0; i -= i & -i) {
            res -= BIT[i];
        }
        return res;
    }

    static class Triplet {
        int a, b, c;

        Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}