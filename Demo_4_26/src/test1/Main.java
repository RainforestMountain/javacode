package test1;

import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Graph graph = new Graph(N);
        for (int i = 0; i < M; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        }
        int K = scanner.nextInt();
        for (int i = 0; i < K; i++) {
            int Np = scanner.nextInt();
            for (int j = 0; j < Np; j++) {
                int vertex = scanner.nextInt();
                graph.deleteEdge(vertex);
            }
            out.println(graph.isSuccess());
            graph.recover();
            //out.flush();
        }
        out.close();
    }

}

class Graph {
    int[] vertex;
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashMap<Integer, List<Integer>> postMap = new HashMap<>();

    public Graph(int n) {
        this.vertex = new int[n];
        for (int i = 1; i <= n; i++) {
            map.put(i, new LinkedList<>());
            postMap.put(i, new LinkedList<>());
        }
    }

    //无向边
    public void addEdge(int i, int j) {
        map.get(i).add(j);
        map.get(j).add(i);
        postMap.get(i).add(j);
        postMap.get(j).add(i);
    }

    //结点的度
    public int getDegree(int i) {
        return map.get(i).size();
    }

    public void deleteEdge(int i) {
        for (Integer v : map.get(i)) {
            map.get(v).remove(new Integer(i));
        }
        map.get(i).clear();
    }

    public void recover() {
        Set<Map.Entry<Integer, List<Integer>>> entrySet = postMap.entrySet();
        for (Map.Entry<Integer, List<Integer>> val : entrySet) {
            map.put(new Integer(val.getKey()), new LinkedList<>(val.getValue()));
        }
    }

    public String isSuccess() {
        int sum = 0;
        for (int i = 1; i <= vertex.length; i++) {
            sum += getDegree(i);
        }
        if (sum == 0) {
            return "Yes";
        } else {
            return "No";
        }
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