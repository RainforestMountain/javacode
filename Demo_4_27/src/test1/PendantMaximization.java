package test1;

import java.util.*;

public class PendantMaximization {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge) {
            return compareEdge.weight - this.weight;
        }
    }

    static class Subset {
        int parent, rank;
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    int maxEdgeSum(int n, String[] arr) {
        int m = arr[0].length();
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int maxLen = 0;
                for (int k = 0; k < m; k++) {
                    String rotated = arr[j].substring(k) + arr[j].substring(0, k);
                    maxLen = Math.max(maxLen, longestCommonSubstring(arr[i], rotated));
                }
                edges.add(new Edge(i, j, maxLen));
            }
        }

        Collections.sort(edges);

        Subset[] subsets = new Subset[n];
        for (int v = 0; v < n; ++v) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        int result = 0;
        int e = 0;
        int i = 0;
        while (e < n - 1 && i < edges.size()) {
            Edge next_edge = edges.get(i++);
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result += next_edge.weight;
                union(subsets, x, y);
                e++;
            }
        }

        return result;
    }

    int longestCommonSubstring(String s1, String s2) {
        int maxLen = 0;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }
        scanner.close();

        PendantMaximization solution = new PendantMaximization();
        System.out.println(solution.maxEdgeSum(n, arr));
    }
}
