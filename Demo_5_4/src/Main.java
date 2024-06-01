import java.util.*;
import java.io.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息


class Fruit  {
    public long happy;
    public long shame;
    public Fruit() {

    }
    public String toString() {
        return "happy = " + happy + ", shame = " + shame;
    }
}
public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
    static Read scanner = new Read();
    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Fruit[] fruits = new Fruit[n];

        for (int i = 0; i < n; i++) {
            fruits[i] = new Fruit();
            fruits[i].happy = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            fruits[i].shame = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k && i +j < n; j++) {
                fruits[i].happy += fruits[i + j].happy;
                fruits[i].shame += fruits[i + j].shame;
            }
        }
        Arrays.sort(fruits,new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return 0;
            }


        });



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