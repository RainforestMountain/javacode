package test9;

import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        Graph graph = new Graph();
        graph.initArray(n);
        int root = 0;
        int[] degree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int parent = scanner.nextInt();
            if (parent == 0) {
                root = i;
            } else {
                graph.addEdge(parent, i);
                degree[parent]++;
            }
        }
//        graph.printGraph();
        int max = -1;
        int sum = 0;
        int count = 0;
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] != 0) {
                count++;
            }
            max = Math.max(max, degree[i]);
            sum = sum + degree[i];
        }
        out.print(max + " ");
        if (sum != max * count) {
            out.println("no");
        } else {
            out.println("yes");
        }
        out.flush();
        List<Integer> ans = graph.dfs(root);
        for (int i = 0; i < ans.size(); i++) {
            if (i == ans.size() - 1) {
                out.print(ans.get(i));
            } else {
                out.print(ans.get(i) + " ");
            }
        }
        out.close();
    }
}

//有向图
class Graph {
    HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
    int[] vertex;


    public void initArray(int n) {
        this.vertex = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adjMap.put(i, new ArrayList<>());
        }
    }

    //有向边
    public void addEdge(int i, int j) {
        adjMap.get(i).add(j);
    }

    public List<Integer> dfs(int j) {
        boolean[] visited = new boolean[vertex.length];
        dfsChild(j, visited);
        return list;
    }

    public List<Integer> list = new ArrayList<>();

    public void dfsChild(int v, boolean[] visited) {
        list.add(v);
        visited[v] = true;
        for (Integer value : adjMap.get(v)) {
            dfsChild(value, visited);
        }
    }

    public void printGraph() {
        for (int i = 1; i < vertex.length; i++) {
            System.out.print(i + ": ");
            for (Integer value : adjMap.get(i)) {
                System.out.print(value + " ");
            }
            System.out.println();
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


