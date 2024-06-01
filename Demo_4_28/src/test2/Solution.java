package test2;

import java.util.*;

class Graph {
    List<Character> vertex = new ArrayList<>();
    HashMap<Character, List<Edge>> matrix = new HashMap<>();

    public Graph(char[] vertex) {
        for (int i = 0; i < vertex.length; i++) {
            this.vertex.add(vertex[i]);
            matrix.put(vertex[i], new ArrayList<>());
        }
    }

    //无向边
    public void addEdge(char i, char j, int weight) {
        matrix.get(i).add(new Edge(i, j, weight));
        matrix.get(j).add(new Edge(j, i, weight));
    }

    public void bfs(char begin) {
        Queue<Character> queue = new LinkedList<>();
        int[] visited = new int[vertex.size()];
        queue.offer(begin);
        char cur = begin;
        int index = vertex.indexOf(cur);
        visited[index] = 1;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.print(cur + " ");
            for (Edge edge : matrix.get(cur)) {
                int i = vertex.indexOf(edge.getDest());
                if (visited[i] == 0) {
                    queue.add(edge.getDest());
                    visited[i] = 1;
                }
            }
        }
    }

    static class Edge {
        char src;
        char dest;
        int weight;

        Edge(char src, char dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        char getDest() {
            return dest;
        }
    }

}

public class Solution {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D'};
        Graph graph = new Graph(vertex);
        graph.addEdge('A', 'B', 5);
        graph.addEdge('A', 'C', 1);
        graph.addEdge('B', 'D', 7);
        graph.addEdge('A', 'D', 8);
        graph.addEdge('C', 'D', 2);
        graph.bfs('A');

    }
}
