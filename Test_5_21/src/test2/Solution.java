package test2;


class NumMatrix {
    private int[][] matrix;
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        get_sum();
    }

    public void get_sum() {
        this.sum = new int[matrix.length + 1][matrix[0].length + 1];//下标映射sum数组比matrix减一
        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum.length; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public void update(int row, int col, int val) {
        this.matrix[row][col] = val;
        get_sum();
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1  + 1 - 1][col2 + 1] - sum[row2 + 1][col1  + 1 - 1]
                + sum[row1 + 1 - 1][col1 + 1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        obj.update(3, 2, 2);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
    }

}
