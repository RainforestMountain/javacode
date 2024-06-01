package test2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] matrix = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        int row = 0;
        int col = 0;
        for (int i = 0; i < n; i++) {
            String src = scanner.next();
            for (int j = 0; j < src.length(); j++) {
                if (src.charAt(j) == 'k') {
                    row = i;
                    col = j;
                }
                matrix[i][j] = src.charAt(j);
            }
        }
        //广度优先遍历,多源bfs
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int minStep = 0;
        int step = 0;
        boolean first = false;
        int ret = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] path = queue.poll();
                int x = path[0];
                int y = path[1];

                for (int j = 0; j < 4; j++) {
                    int next_x = x + dx[j];
                    int next_y = y + dy[j];
                    if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m
                            && matrix[next_x][next_y] != '*' && !visited[next_x][next_y]) {
                        if (matrix[next_x][next_y] == 'e' && !first) {
                            first = true;
                            minStep = step + 1;
                            ret++;
                        } else if (matrix[next_x][next_y] == 'e' && first) {
                            ret++;
                        } else {
                            queue.add(new int[]{next_x, next_y});
                        }
                        visited[next_x][next_y] = true;
                    }
                }
            }
            step++;
        }
        if (ret == 0) {
            System.out.println(-1);
        } else {
            System.out.println(ret + " " + minStep);
        }

    }
}
