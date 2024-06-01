import java.util.Arrays;
import java.util.Comparator;
import java.io.*;
import java.util.StringTokenizer;

class People {
    int id;
    int money;
    int count_red;
}

public class Main {
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static Read in = new Read();

    public static void initPeopleArray(People[] peoples) {
        for (int i = 0; i < peoples.length; i++) {
            peoples[i] = new People();
            peoples[i].id = i + 1;
        }
    }

    public static void main(String[] args) throws IOException {

        int N = in.nextInt();
        People[] peopels = new People[N];
        initPeopleArray(peopels);
        for (int i = 0; i < N; i++) {
            int K = in.nextInt();
            int sumMoney = 0;
            for (int j = 0; j < K; j++) {
                int people_id = in.nextInt() - 1;
                int money = in.nextInt();
                sumMoney += money;
                peopels[people_id].money += money;
                peopels[people_id].count_red++;
            }
            peopels[i].money -= sumMoney;
        }

        Arrays.sort(peopels, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o1.money < o2.money) {
                    return 1;
                } else if (o1.money > o2.money) {
                    return -1;
                } else {
                    if (o1.count_red < o2.count_red) {
                        return 1;
                    } else if (o1.count_red > o2.count_red) {
                        return -1;
                    } else {
                        return o1.id - o2.id;
                    }
                }
            }
        });
        for (int i = 0; i < peopels.length; i++) {
            out.print(peopels[i].id + " ");
            out.printf("%.2f\n", peopels[i].money * 1.0 / 100);
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