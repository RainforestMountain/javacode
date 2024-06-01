package test3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int card_w = scanner.nextInt();
        int card_h = scanner.nextInt();
        Envelope[] envelopes = new Envelope[n];
        for (int i = 1; i <= n; i++) {
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            envelopes[i - 1] = new Envelope(i, w, h);
        }
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1.w > o2.w) {
                return 1;
            } else if (o1.w < o2.w) {
                return -1;
            } else {
                return o1.h - o2.h;
            }
        });
        int[] dp = new int[n];
        dp[0] = 0;
        List<Envelope> list = new ArrayList<>();
        if (card_w >= envelopes[n - 1].w || card_h >= envelopes[n - 1].h) {
            out.println(0);
        } else {
            for (int i = 0; i < envelopes.length; i++) {
                if (envelopes[i].h <= card_h || envelopes[i].w <= card_w) {
                    continue;
                }
                if (list.isEmpty()) {
                    list.add(envelopes[i]);
                    continue;
                }
                int w = envelopes[i].w;
                int h = envelopes[i].h;
                if (w > list.get(list.size() - 1).w && h > list.get(list.size() - 1).h) {
                    list.add(envelopes[i]);
                }
            }
            if (list.isEmpty()) {
                out.println(0);
            } else {
                out.println(list.size());
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) {
                        out.print(list.get(i).id);
                    } else {
                        out.print(list.get(i).id + " ");
                    }
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

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}

class Envelope {
    int id;
    int w;
    int h;

    public Envelope(int id, int w, int h) {
        this.id = id;
        this.w = w;
        this.h = h;
    }
}
