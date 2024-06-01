package test1;

import java.util.*;
import java.io.*;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int N = scanner.nextInt();
        HashSet<Integer>[] interestSet = new HashSet[15];
        UnionFindSet friendSet = new UnionFindSet(15);
        for (int i = 0; i < interestSet.length; i++) {
            interestSet[i] = new HashSet<>();
        }
        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(scanner.next().charAt(0) + "");
            friendSet.elem[i] = -1;
            for (int j = 1; j <= val; j++) {
                int num = scanner.nextInt();
                for (Integer v : interestSet[i]) {
                    friendSet.merge(i, v);
                }
                interestSet[num].add(i);
            }
        }

        out.println(friendSet.getCount());
        List<Integer> list = friendSet.getEverySetCount();
        Collections.sort(list, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                }
        );
        for(int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                out.print(list.get(i));
            } else {
                out.print(list.get(i) + " ");
            }

        }
        out.close();
    }
}

class UnionFindSet {
    public int[] elem;

    public UnionFindSet(int n) {
        this.elem = new int[n];
        Arrays.fill(elem, -2000);
    }

    public int find(int x) {
        if (x < 0) {
            throw new RuntimeException("数据不合法");
        }
        while (elem[x] >= 0) {
            x = elem[x];
        }
        return x;
    }

    public boolean isSameSet(int x1, int x2) {
        int root1 = find(x1);
        int root2 = find(x2);
        if (root1 == root2) {
            return true;
        }
        return false;
    }

    //合并后x1的根是新集合的根
    public boolean merge(int x1, int x2) {
        int root1 = find(x1);
        int root2 = find(x2);
        if (root1 == root2) {
            return false;
        }

        elem[root1] = elem[root1] + elem[root2];

        elem[root2] = root1;
//        elem[x2] = root1;
//        elem[x1] = root1;
        return true;
    }

    public int getCount() {
        int count = 0;
        for (int i = 0; i < elem.length; i++) {
            if (elem[i] < 0 && elem[i] != -2000) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getEverySetCount() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < elem.length; i++) {
            if (elem[i] < 0 && elem[i] != -2000) {
                list.add(Math.abs(elem[i]));
            }
        }
        return list;
    }
}

class Read {
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String next() throws IOException {
        while (!st.hasMoreElements()) {
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

    Long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    Double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
