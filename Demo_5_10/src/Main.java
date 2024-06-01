import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) {




    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //一层一层模拟
        int left_x = 0;
        int left_y = 0;
        int right_x = m - 1;
        int right_y = n - 1;
        List<Integer> result = new ArrayList<>();
        while (right_x >= left_x && right_y >= left_y) {
            if (right_x == left_x || right_y == left_y) {
                if (right_x == left_x) {
                    for (int j = left_y; j <= right_y; j++) {
                        result.add(matrix[left_x][j]);
                    }
                } else {
                    for (int i = left_x; i <= right_x; i++) {
                        result.add(matrix[i][right_y]);
                    }
                }
            } else {
                //从左到右
                for (int j = left_y; j <= right_y - 1; j++) {
                    result.add(matrix[left_x][j]);
                }
                //从上到下
                for (int i = left_x; i <= right_x - 1; i++) {
                    result.add(matrix[i][right_y]);
                }
                //从右到左
                for (int j = right_y; j >= left_y + 1; j--) {
                    result.add(matrix[right_x][j]);
                }
                //从上到下
                for (int i = right_x; i >= left_x + 1; i--) {
                    result.add(matrix[i][left_y]);
                }
            }
            left_x++;
            left_y++;
            right_x--;
            right_y--;
        }
        return result;
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
