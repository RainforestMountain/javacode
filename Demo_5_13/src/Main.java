import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] matrix = new char[n][m];
        int tx = 0;
        int ty = 0;
        int sx = 0;
        int sy = 0;
        for (int i = 0; i < n; i++) {
            String temp = scanner.next();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = temp.charAt(j);
                if (temp.charAt(j) == 'S') {
                    sx = j;
                    sy = i;
                }
                if (temp.charAt(j) == 'T') {
                    tx = j;
                    ty = i;
                }
            }
        }
        //多源bfs
        int step = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy});
        matrix[sy][sx] = ' ';
        int[] dx = {0, 0, -1, 1};//列坐标,横坐标
        int[] dy = {-1, 1, 0, 0};//行坐标,纵坐标
        boolean[][] visited = new boolean[n][m];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] path = queue.poll();
                int x = path[0];
                int y = path[1];
                //四个方向,可以走多步,直到遇到墙壁
                for (int i = 0; i < 4; i++) {
                    int next_x = x + dx[i];
                    int next_y = y + dy[i];

                    while (next_x >= 0 && next_x < m && next_y >= 0 && next_y < n
                            && matrix[next_y][next_x] != '#' && visited[next_y][next_x] == false) {
                        //visited[next_y][next_x] = false;
                        next_x += dx[i];
                        next_y += dy[i];
                    }
                    next_x -= dx[i];
                    next_y -= dy[i];

                    if (next_x == tx && next_y == ty) {
                        out.println(step + 1);
                        out.close();
                        return;
                    }
                    if (visited[next_y][next_x] == false && matrix[next_y][next_x] == '.') {
                        queue.add(new int[]{next_x, next_y});
                        visited[next_y][next_x] = true;
                    }
                }
            }
            step++;
        }
        out.println(-1);
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